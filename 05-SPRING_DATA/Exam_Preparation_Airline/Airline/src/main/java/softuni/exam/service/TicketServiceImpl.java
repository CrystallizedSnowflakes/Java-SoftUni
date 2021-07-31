package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TicketSeedDto;
import softuni.exam.models.dto.TicketSeedRootDto;
import softuni.exam.models.entities.Ticket;
import softuni.exam.repository.TicketRepository;
import softuni.exam.service.api.PassengerService;
import softuni.exam.service.api.PlaneService;
import softuni.exam.service.api.TicketService;
import softuni.exam.service.api.TownService;
import softuni.exam.util.api.ValidationUtil;
import softuni.exam.util.api.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    private static final String TICKETS_FILE_PATH = "src/main/resources/files/xml/tickets.xml";

    private final TicketRepository ticketRepository;
    private final TownService townService;
    private final PassengerService passengerService;
    private final PlaneService planeService;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public TicketServiceImpl(TicketRepository ticketRepository, TownService townService,
                             PassengerService passengerService, PlaneService planeService,
                             XmlParser xmlParser, ValidationUtil validationUtil,
                             ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.townService = townService;
        this.passengerService = passengerService;
        this.planeService = planeService;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean areImported() {
        return this.ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files
                .readString(Path.of(TICKETS_FILE_PATH));
    }

    @Override
    public String importTickets() throws JAXBException, FileNotFoundException {

        TicketSeedRootDto ticketSeedRootDTOs = this.xmlParser
                .readFromFilePath(TICKETS_FILE_PATH, TicketSeedRootDto.class);

        StringBuilder sb = new StringBuilder();

        ticketSeedRootDTOs.getTickets()
                .stream()
                .filter(ticketSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(ticketSeedDto)
                            && !isEntityExists(ticketSeedDto.getSerialNumber())
                            && this.townService.isEntityExists(ticketSeedDto.getFromTown().getName())
                            && this.townService.isEntityExists(ticketSeedDto.getToTown().getName())
                            && this.passengerService.isEntityExists(ticketSeedDto.getPassenger().getEmail())
                            && this.planeService.isEntityExists(ticketSeedDto.getPlane().getRegisterNumber());
                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Ticket %s - %s",
                                    ticketSeedDto.getFromTown(),
                                    ticketSeedDto.getToTown())
                                    : "Invalid Ticket")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(ticketSeedDto -> {
                    Ticket ticket = this.modelMapper.map(ticketSeedDto, Ticket.class);
                    ticket.setFromTown(this.townService.findByName(ticketSeedDto.getFromTown().getName()));
                    ticket.setToTown(this.townService.findByName(ticketSeedDto.getToTown().getName()));
                    ticket.setPassenger(this.passengerService.findByEmail(ticketSeedDto.getPassenger().getEmail()));
                    ticket.setPlane(this.planeService.findByRegisterNumber(ticketSeedDto.getPlane().getRegisterNumber()));
                    return ticket;
                })
                .forEach(this.ticketRepository::save);

        return sb.toString().trim();
    }

    private boolean isEntityExists(String serialNumber) {
        return this.ticketRepository.existsBySerialNumber(serialNumber);
    }
}
