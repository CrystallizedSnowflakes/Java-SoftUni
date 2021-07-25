package com.example.json_exercise.service.impl;

import com.example.json_exercise.constants.GlobalConstants;
import com.example.json_exercise.model.dto.*;
import com.example.json_exercise.model.entity.User;
import com.example.json_exercise.repository.UserRepository;
import com.example.json_exercise.service.UserService;
import com.example.json_exercise.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public void seedUsers() throws IOException {
        if (this.userRepository.count() == 0) {
            Arrays.stream(gson
                    .fromJson(
                            Files.readString(
                                    Path.of(GlobalConstants.RESOURCE_FILE_PATH + GlobalConstants.FROM_USERS_FILE)),
                            UserSeedDto[].class))
                    .filter(validationUtil::isValid)
                    .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                    .forEach(userRepository::save);
        }
    }

    @Override
    public User findRandomUser() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1, userRepository.count() + 1);
        return this.userRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    public List<UserSoldDto> findAllUsersWithAtLeastOneSoldProductOrderByLastNameThenByFirstName() {
        return this.userRepository.
                findAllUsersWithMoreThanOneSoldProductOrderByLastNameThenByFirstName()
                .stream()
                .map(user -> modelMapper.map(user, UserSoldDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsersCountAndUserInfoDto findAllUsersWithAtLeastOneSoldProductOrderByProductsCountDescThenByLastName() {
        List<User> allUsers = this.userRepository
                .findAllUsersWithMoreThanOneSoldProductOrderByProductsCountDescThenByLastName();

        var usersCountAndUserInfoDto = new UsersCountAndUserInfoDto();

        usersCountAndUserInfoDto.setUsersCount(allUsers.size());
        usersCountAndUserInfoDto.setUsers(allUsers
                .stream()
                .map(user -> {
                    var userInfoAndSoldProductsDto = this.modelMapper.map(user, UserInfoAndSoldProductsDto.class);

                    var soldProductsCountAndProductsInfoDto = new SoldProductsCountAndProductsInfoDto();
                    soldProductsCountAndProductsInfoDto.setProducts(user
                            .getSoldProducts()
                            .stream()
                            .map(product -> this.modelMapper.map(product, SoldProductNameAndPriceDto.class))
                            .collect(Collectors.toSet()));

                    soldProductsCountAndProductsInfoDto.setCount(user.getSoldProducts().size());
                    userInfoAndSoldProductsDto.setSoldProducts(soldProductsCountAndProductsInfoDto);

                    return userInfoAndSoldProductsDto;

                })
                .collect(Collectors.toSet()));

        return usersCountAndUserInfoDto;
    }
}
