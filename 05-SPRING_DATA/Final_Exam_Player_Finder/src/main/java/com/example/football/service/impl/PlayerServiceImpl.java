package com.example.football.service.impl;

import com.example.football.models.dto.PlayerSeedRootDto;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final String PLAYERS_FILE_PATH = "src/main/resources/files/xml/players.xml";

    private final PlayerRepository playerRepository;
    private final TownService townService;
    private final TeamService teamService;
    private final StatService statService;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public PlayerServiceImpl(PlayerRepository playerRepository, TownService townService,
                             TeamService teamService, StatService statService, XmlParser xmlParser,
                             ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.playerRepository = playerRepository;
        this.townService = townService;
        this.teamService = teamService;
        this.statService = statService;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files
                .readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        PlayerSeedRootDto playerSeedRootDto = this.xmlParser
                .readFromFilePath(PLAYERS_FILE_PATH, PlayerSeedRootDto.class);

        StringBuilder sb = new StringBuilder();

        playerSeedRootDto.getPlayers()
                .stream()
                .filter(playerSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(playerSeedDto)
                            && !isEntityExists(playerSeedDto.getEmail())
                            && this.townService.isEntityExists(playerSeedDto.getTown().getName())
                            && this.teamService.isEntityExists(playerSeedDto.getTeam().getName())
                            && this.statService.isEntityExistsById(playerSeedDto.getStat().getId());

                    sb.append(isValid
                                    ? String.format("Successfully imported Player %s %s - %s",
                                    playerSeedDto.getFirstname(),
                                    playerSeedDto.getLastname(),
                                    playerSeedDto.getPosition())
                                    : "Invalid Player")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(playerSeedDto -> {
                    Player player = this.modelMapper.map(playerSeedDto, Player.class);
                    player.setTown(this.townService.findByName(playerSeedDto.getTown().getName()));
                    player.setTeam(this.teamService.findByName(playerSeedDto.getTeam().getName()));
                    player.setStat(this.statService.findById(playerSeedDto.getStat().getId()));
                    return player;
                })
                .forEach(this.playerRepository::save);

        return sb.toString().trim();
    }

    private boolean isEntityExists(String email) {
        return this.playerRepository.existsByEmail(email);
    }

    @Override
    public String exportBestPlayers() {

        List<Player> bestPlayers = this.playerRepository
                .findBestPlayersAndTheirStats();

        StringBuilder sb = new StringBuilder();
        bestPlayers
                .stream()
                .map(Player::toString)
                .forEach(player -> sb.append(player).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
