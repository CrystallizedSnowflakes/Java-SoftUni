package com.example.json_exercise.repository;

import com.example.json_exercise.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u " +
            "JOIN FETCH u.soldProducts p " +
            "WHERE u.soldProducts.size > 0 AND p.buyer IS NOT NULL " +
            "ORDER BY u.lastName, u.firstName")
    List<User> findAllUsersWithMoreThanOneSoldProductOrderByLastNameThenByFirstName();


    @Query("SELECT u FROM User u " +
            "JOIN FETCH u.soldProducts p " +
            "WHERE u.soldProducts.size > 0 AND p.buyer IS NOT NULL " +
            "ORDER BY u.soldProducts.size DESC, u.lastName")
    List<User> findAllUsersWithMoreThanOneSoldProductOrderByProductsCountDescThenByLastName();
}
