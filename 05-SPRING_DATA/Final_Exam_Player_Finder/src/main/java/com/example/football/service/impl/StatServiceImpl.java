package com.example.football.service.impl;

import com.example.football.models.dto.StatSeedRootDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatServiceImpl implements StatService {

    private static final String STATS_FILE_PATH = "src/main/resources/files/xml/stats.xml";

    private final StatRepository statRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public StatServiceImpl(StatRepository statRepository, XmlParser xmlParser,
                           ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.statRepository = statRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files
                .readString(Path.of(STATS_FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {

        StatSeedRootDto statSeedRootDto = this.xmlParser
                .readFromFilePath(STATS_FILE_PATH, StatSeedRootDto.class);

        StringBuilder sb = new StringBuilder();

        statSeedRootDto.getStats()
                .stream()
                .filter(statSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(statSeedDto)
                            && !isEntityExists(statSeedDto.getPassing(),
                            statSeedDto.getShooting(),
                            statSeedDto.getEndurance());
                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Stat %.2f - %.2f - %.2f",
                                    statSeedDto.getPassing(),
                                    statSeedDto.getShooting(),
                                    statSeedDto.getEndurance())
                                    : "Invalid Stat")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(statSeedDto -> this.modelMapper.map(statSeedDto, Stat.class))
                .forEach(this.statRepository::save);

        return sb.toString().trim();
    }

    @Override
    public boolean isEntityExistsById(Long id) {
        return this.statRepository.existsById(id);
    }

    @Override
    public Stat findById(Long id) {
        return this.statRepository.findById(id).orElse(null);
    }


    private boolean isEntityExists(Float passing, Float shooting, Float endurance) {
        return this.statRepository.existsByPassing(passing)
                && this.statRepository.existsByShooting(shooting)
                && this.statRepository.existsByEndurance(endurance);
    }


}
