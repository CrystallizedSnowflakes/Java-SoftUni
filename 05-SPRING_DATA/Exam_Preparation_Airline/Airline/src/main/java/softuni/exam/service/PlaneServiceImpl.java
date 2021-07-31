package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PlaneSeedRootDto;
import softuni.exam.models.entities.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.api.PlaneService;
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
public class PlaneServiceImpl implements PlaneService {

    private static final String PLANES_FILE_PATH = "src/main/resources/files/xml/planes.xml";

    private final PlaneRepository planeRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public PlaneServiceImpl(PlaneRepository planeRepository, ValidationUtil validationUtil,
                            ModelMapper modelMapper, XmlParser xmlParser) {
        this.planeRepository = planeRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files
                .readString(Path.of(PLANES_FILE_PATH));
    }

    @Override
    public String importPlanes() throws JAXBException, FileNotFoundException {

        PlaneSeedRootDto planeSeedRootDto = this.xmlParser.readFromFilePath(PLANES_FILE_PATH, PlaneSeedRootDto.class);

        StringBuilder sb = new StringBuilder();

        planeSeedRootDto.getPlanes()
                .stream()
                .filter(planeSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(planeSeedDto);
                    sb
                            .append(isValid ?
                                    String.format("Successfully imported Plane %s",
                                            planeSeedDto.getRegisterNumber())
                                    : "Invalid Plane")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(planeSeedDto -> this.modelMapper.map(planeSeedDto, Plane.class)
                )
                .forEach(this.planeRepository::save);

        return sb.toString().trim();
    }

    @Override
    public Plane findByRegisterNumber(String registerNumber) {
        return this.planeRepository.findByRegisterNumber(registerNumber);
    }
}
