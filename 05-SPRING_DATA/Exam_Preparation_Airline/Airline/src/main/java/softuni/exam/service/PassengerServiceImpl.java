package softuni.exam.service;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PassengerSeedDto;
import softuni.exam.models.entities.Passenger;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.service.api.PassengerService;
import softuni.exam.service.api.TownService;
import softuni.exam.util.api.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImpl implements PassengerService {

    private static final String PASSENGERS_FILE_PATH = "src/main/resources/files/json/passengers.json";

    private final PassengerRepository passengerRepository;
    private final TownService townService;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public PassengerServiceImpl(PassengerRepository passengerRepository, TownService townService,
                                ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.passengerRepository = passengerRepository;
        this.townService = townService;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files
                .readString(Path.of(PASSENGERS_FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {
        PassengerSeedDto[] passengerSeedDTOs = this.gson.fromJson(readPassengersFileContent(), PassengerSeedDto[].class);
        StringBuilder sb = new StringBuilder();
        Arrays
                .stream(passengerSeedDTOs)
                .filter(passengerSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(passengerSeedDto);
                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Passenger %s - %s",
                                    passengerSeedDto.getLastName(),
                                    passengerSeedDto.getEmail())
                                    : "Invalid Passenger")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(passengerSeedDto -> {
                    Passenger passenger = this.modelMapper.map(passengerSeedDto, Passenger.class);
                    passenger.setTown(this.townService.findByName(passengerSeedDto.getTown()));
                    return passenger;
                })
                .forEach(this.passengerRepository::save);

        return sb.toString().trim();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        StringBuilder sb = new StringBuilder();
        List<Passenger> passengers = this.passengerRepository
                .findAllPassengersOrderByTicketsCountDescThenByEmail();
        passengers.forEach(passenger -> {
            sb
                    .append(String.format("Passenger %s  %s\n" +
                            "\tEmail - {%s}\n" +
                            "\tPhone - {%s}\n" +
                            "\tNumber of tickets - {%d}\n",
                            passenger.getFirstName(),
                            passenger.getLastName(),
                            passenger.getEmail(),
                            passenger.getPhoneNumber(),
                            passenger.getTickets().size()))
                    .append(System.lineSeparator());
        });
        return sb.toString();
    }

    @Override
    public Passenger findByEmail(String email) {
        return this.passengerRepository.findByEmail(email);
    }
}
