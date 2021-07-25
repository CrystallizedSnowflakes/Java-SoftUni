package com.example.json_exercise.service;

import com.example.json_exercise.model.dto.UserSoldDto;
import com.example.json_exercise.model.dto.UsersCountAndUserInfoDto;
import com.example.json_exercise.model.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    void seedUsers() throws IOException;

    User findRandomUser();

    List<UserSoldDto> findAllUsersWithAtLeastOneSoldProductOrderByLastNameThenByFirstName();

    UsersCountAndUserInfoDto findAllUsersWithAtLeastOneSoldProductOrderByProductsCountDescThenByLastName();
}
