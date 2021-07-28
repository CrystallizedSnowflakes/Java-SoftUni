package com.example.xmlex.service.impl;

import com.example.xmlex.model.dto.seed.UserSeedDto;
import com.example.xmlex.model.dto.soldProducts.UserViewRootDto;
import com.example.xmlex.model.dto.soldProducts.UserWithProductsDto;
import com.example.xmlex.model.dto.users.ProductInfoDto;
import com.example.xmlex.model.dto.users.SoldProductsDto;
import com.example.xmlex.model.dto.users.UserAndProductsViewRootDto;
import com.example.xmlex.model.dto.users.UserInfoDto;
import com.example.xmlex.model.entity.User;
import com.example.xmlex.repository.UserRepository;
import com.example.xmlex.service.UserService;
import com.example.xmlex.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public long getEntityCount() {
        return this.userRepository.count();
    }

    @Override
    public void seedUsers(List<UserSeedDto> users) {

        users
                .stream()
                .filter(this.validationUtil::isValid)
                .map(userSeedDto -> this.modelMapper.map(userSeedDto, User.class))
                .forEach(this.userRepository::save);
    }

    @Override
    public User getRandomUser() {
        long randomId = ThreadLocalRandom.current().nextLong(1, this.userRepository.count() + 1);
        return this.userRepository.findById(randomId).orElse(null);
    }

    @Override
    public UserViewRootDto findUsersWithMoreThanOneSoldProduct() {
        UserViewRootDto userViewRootDto = new UserViewRootDto();

        userViewRootDto
                .setUsers(this.userRepository
                .findAllUsersWithBuyerNotNullOrderByLastNameThenByFirstName()
                .stream()
                .map(user -> this.modelMapper.map(user, UserWithProductsDto.class))
                .collect(Collectors.toList()));

        return userViewRootDto;
    }

    @Override
    public UserAndProductsViewRootDto findAllUsersAndProductInfo() {
        List<User> users = this.userRepository
                .findAllUsersWithBuyerNotNullOrderByLastNameThenByFirstName();

        UserAndProductsViewRootDto userAndProductsViewRootDto = new UserAndProductsViewRootDto();
        userAndProductsViewRootDto.setCount(users.size());
        userAndProductsViewRootDto.setUsers(users
            .stream()
            .map(user -> {
                UserInfoDto userInfoDto = this.modelMapper.map(user, UserInfoDto.class);
                SoldProductsDto soldProductsDto = new SoldProductsDto();
                soldProductsDto.setProductCount(user.getSoldProducts().size());
                soldProductsDto.setProducts(user
                        .getSoldProducts()
                        .stream()
                        .map(product -> this.modelMapper.map(product, ProductInfoDto.class))
                        .collect(Collectors.toList()));
                userInfoDto.setProducts(soldProductsDto);
                return userInfoDto;
            })
            .collect(Collectors.toList()));

        System.out.println();
        return userAndProductsViewRootDto;
    }
}
