package com.example.dto_game_store.service.impl;

import com.example.dto_game_store.model.dto.UserLoginDto;
import com.example.dto_game_store.model.dto.UserRegisterDto;
import com.example.dto_game_store.model.entity.Game;
import com.example.dto_game_store.model.entity.User;
import com.example.dto_game_store.repository.UserRepository;
import com.example.dto_game_store.service.GameService;
import com.example.dto_game_store.service.UserService;
import com.example.dto_game_store.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private User loggedInUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {

        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            System.out.println("Wrong confirm password");
            return;
        }

        Set<ConstraintViolation<UserRegisterDto>> violations = validationUtil.getViolations(userRegisterDto);

        if (!violations.isEmpty()){
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        //todo map dto to entity and save in DB

        User user = modelMapper.map(userRegisterDto, User.class);
        user.setAdmin(true);
        userRepository.save(user);
        System.out.println(user.getFullName() + " was registered");
    }

    @Override
    public void loginUser(UserLoginDto userLoginDto) {
        Set<ConstraintViolation<UserLoginDto>> violations = validationUtil.getViolations(userLoginDto);

        if (!violations.isEmpty()){
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        User user = userRepository
                .findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword())
                .orElse(null);

        if (user == null){
            System.out.println("No such user. You need a registration first.");
            return;
        }

        loggedInUser = user;
        loggedInUser.setAdmin(true);
        System.out.println("Successfully logged in " + loggedInUser.getFullName());
    }

    @Override
    public void logout() {
        if (loggedInUser == null){
            System.out.println("Cannot log out. No user was logged in.");
        } else {
            String name = loggedInUser.getFullName();
            loggedInUser = null;
            System.out.println("User " + name + " successfully logged out");
        }
    }

    @Override
    public boolean hasLoggedInUser() {
        return loggedInUser != null;
    }

    @Override
    public boolean isLoggedUserAnAdmin() {
        return loggedInUser.isAdmin();
    }

    @Override
    public void printGamesTitlesOwnedByUser() {
        if (!hasLoggedInUser()){
            System.out.println("There is no logged in user");
            return;
        }
        this.loggedInUser.getGames()
                .stream()
                .map(Game::getTitle)
                .forEach(System.out::println);

    }

    @Override
    public void addGameToUser(Game game) {
        this.loggedInUser.purchase(game);
    }
}
