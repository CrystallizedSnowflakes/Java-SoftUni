package com.example.dto_game_store.service;

import com.example.dto_game_store.model.dto.UserLoginDto;
import com.example.dto_game_store.model.dto.UserRegisterDto;
import com.example.dto_game_store.model.entity.Game;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();

    boolean hasLoggedInUser();

    boolean isLoggedUserAnAdmin();

    void printGamesTitlesOwnedByUser();

    void addGameToUser(Game game);
}
