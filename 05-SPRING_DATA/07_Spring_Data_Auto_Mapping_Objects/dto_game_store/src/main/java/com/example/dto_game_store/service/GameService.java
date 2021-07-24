package com.example.dto_game_store.service;

import com.example.dto_game_store.model.dto.GameAddDto;
import com.example.dto_game_store.model.entity.Game;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(long gameId, String price, String size);

    void deleteGame(long gameId);

    void findAllGames();

    void findGameByTitle(String command);
}
