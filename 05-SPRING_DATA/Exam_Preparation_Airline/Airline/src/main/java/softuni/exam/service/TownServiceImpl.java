package softuni.exam.service;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownSeedDto;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.api.TownService;
import softuni.exam.util.api.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TownServiceImpl implements TownService {
    private static final String TOWNS_FILE_PATH = "src/main/resources/files/json/towns.json";

    private final TownRepository townRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public TownServiceImpl(TownRepository townRepository, ValidationUtil validationUtil,
                           ModelMapper modelMapper, Gson gson) {
        this.townRepository = townRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files
                .readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {

        TownSeedDto[] townSeedDTOs = this.gson.fromJson(readTownsFileContent(), TownSeedDto[].class);
        StringBuilder sb = new StringBuilder();

        Arrays
                .stream(townSeedDTOs)
                .filter(townSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(townSeedDto)
                            && !isEntityExists(townSeedDto.getName());
                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Town %s - %d",
                                    townSeedDto.getName(),
                                    townSeedDto.getPopulation())
                                    : "Invalid Town")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(townSeedDto -> this.modelMapper.map(townSeedDto, Town.class))
                .forEach(this.townRepository::save);

        return sb.toString().trim();
    }

    @Override
    public boolean isEntityExists(String name) {
        return this.townRepository.existsByName(name);
    }

    @Override
    public Town findByName(String townName) {
        return this.townRepository.findByName(townName);
    }
}
