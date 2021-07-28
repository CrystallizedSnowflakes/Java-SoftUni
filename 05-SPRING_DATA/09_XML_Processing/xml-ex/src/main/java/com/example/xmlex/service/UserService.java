package com.example.xmlex.service;

import com.example.xmlex.model.dto.seed.UserSeedDto;
import com.example.xmlex.model.dto.soldProducts.UserViewRootDto;
import com.example.xmlex.model.dto.users.UserAndProductsViewRootDto;
import com.example.xmlex.model.entity.User;

import java.util.List;

public interface UserService {

    long getEntityCount();

    void seedUsers(List<UserSeedDto> users);

    User getRandomUser();

    UserViewRootDto findUsersWithMoreThanOneSoldProduct();

    UserAndProductsViewRootDto findAllUsersAndProductInfo();
}
