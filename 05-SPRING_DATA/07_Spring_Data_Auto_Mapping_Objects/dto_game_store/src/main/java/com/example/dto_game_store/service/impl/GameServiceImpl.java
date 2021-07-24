package com.example.dto_game_store.service.impl;

import com.example.dto_game_store.model.dto.DetailGameShowDto;
import com.example.dto_game_store.model.dto.GameAddDto;
import com.example.dto_game_store.model.dto.GameShowDto;
import com.example.dto_game_store.model.entity.Game;
import com.example.dto_game_store.repository.GameRepository;
import com.example.dto_game_store.service.GameService;
import com.example.dto_game_store.service.UserService;
import com.example.dto_game_store.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(GameRepository gameRepository, UserService userService,
                           ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {

       if (!userService.hasLoggedInUser()){
           System.out.println("Please login an user first");
            return;
        }

       if (!userService.isLoggedUserAnAdmin()){
           System.out.println("Logged user is not admin");
           return;
       }

        Set<ConstraintViolation<GameAddDto>> violations = validationUtil.getViolations(gameAddDto);

        if (!violations.isEmpty()){
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Game game = modelMapper.map(gameAddDto, Game.class);
        game.setReleaseDate(LocalDate.parse(gameAddDto.getReleaseDate(),
                DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        List<Game> all = gameRepository.findAll();
        Game gamePresent = all.stream().filter(g -> g.getTitle().equals(game.getTitle())).findFirst().orElse(null);
        if (gamePresent != null){
            System.out.println("This game exists already");
            return;
        }

        // todo save in DB
        this.userService.addGameToUser(game);
        gameRepository.save(game);
        System.out.println("Added " + game.getTitle());
    }

    @Override
    public void editGame(long gameId, String price, String size) {

        if (!userService.hasLoggedInUser()){
            System.out.println("Please login an user first");
            return;
        }

        if (!userService.isLoggedUserAnAdmin()){
            System.out.println("Logged user is not admin");
            return;
        }

        Game game = gameRepository
                .findById(gameId)
                .orElse(null);

        if (game == null){
            System.out.println("No such game in DB by this id");
            return;
        }

        String[] priceInfo = Arrays.stream(price.split("=")).skip(1).toArray(String[]::new);
        BigDecimal gamePrice = new BigDecimal(priceInfo[0]);
        game.setPrice(gamePrice);

        String[] sizeInfo = size.split("=");
        Double gameSize = Double.parseDouble(sizeInfo[1]);
        game.setSize(gameSize);

        gameRepository.save(game);
        System.out.println("Edited " + game.getTitle());
    }

    @Override
    public void deleteGame(long gameId) {

        if (!userService.hasLoggedInUser()){
            System.out.println("Please login an user first");
            return;
        }

        if (!userService.isLoggedUserAnAdmin()){
            System.out.println("Logged user is not admin");
            return;
        }

        Game game = gameRepository
                .findById(gameId)
                .orElse(null);

        if (game == null){
            System.out.println("No such game in DB by this id");
            return;
        }

        gameRepository.delete(game);
        System.out.println("Deleted " + game.getTitle());
    }

    @Override
    public void findAllGames() {

        gameRepository
                .findAll()
                .stream()
                .map(game -> this.modelMapper.map(game, GameShowDto.class))
                .forEach(gameShowDto -> System.out.printf("%s %s%n", gameShowDto.getTitle(), gameShowDto.getPrice()));
    }

    @Override
    public void findGameByTitle(String title) {
        Game gameByTitle = gameRepository.findGameByTitle(title);
        if (gameByTitle == null){
            System.out.println("No such game in DB");
            return;
        }
        DetailGameShowDto detailGameShowDto = this.modelMapper.map(gameByTitle, DetailGameShowDto.class);
        System.out.printf("Title: %s%nPrice: %.2f%nDescription: %s%nRelease date: %s%n",
                detailGameShowDto.getTitle(),
                detailGameShowDto.getPrice(),
                detailGameShowDto.getDescription(),
                detailGameShowDto.getReleaseDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
}
