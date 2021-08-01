package com.example.football.service.impl;

import com.example.football.models.dto.TeamSeedDto;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private static final String TEAMS_FILE_PATH = "src/main/resources/files/json/teams.json";

    private final TeamRepository teamRepository;
    private final TownService townService;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public TeamServiceImpl(TeamRepository teamRepository, TownService townService,
                           Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.teamRepository = teamRepository;
        this.townService = townService;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files
                .readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public String importTeams() throws IOException {
        TeamSeedDto[] teamSeedDTOs = this.gson.fromJson(readTeamsFileContent(), TeamSeedDto[].class);
        StringBuilder sb = new StringBuilder();

        Arrays
                .stream(teamSeedDTOs)
                .filter(teamSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(teamSeedDto)
                            && !isEntityExists(teamSeedDto.getName())
                            && this.townService.isEntityExists(teamSeedDto.getTownName());
                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Team %s - %d",
                                    teamSeedDto.getName(),
                                    teamSeedDto.getFanBase())
                                    : "Invalid Team")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(teamSeedDto -> {
                    Team team = this.modelMapper.map(teamSeedDto, Team.class);
                    team.setTown(this.townService.findByName(teamSeedDto.getTownName()));
                    return team;
                })
                .forEach(this.teamRepository::save);
        return sb.toString().trim();
    }

    @Override
    public boolean isEntityExists(String name) {
        return this.teamRepository.existsByName(name);
    }

    @Override
    public Team findByName(String name) {
        return this.teamRepository.findByName(name);
    }
}
