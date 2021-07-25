package com.example.json_exercise.model.dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UsersCountAndUserInfoDto {

    @Expose
    private Integer usersCount;
    @Expose
    private Set<UserInfoAndSoldProductsDto> users;

    public UsersCountAndUserInfoDto() {
    }

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public Set<UserInfoAndSoldProductsDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserInfoAndSoldProductsDto> users) {
        this.users = users;
    }
}
