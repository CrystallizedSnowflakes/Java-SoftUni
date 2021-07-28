package com.example.xmlex.repository;

import com.example.xmlex.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

/*    @Query("SELECT u FROM User u JOIN FETCH Product p " +
            "ON u.id = p.seller.id " +
            "WHERE p.buyer IS NOT NULL " +
            "GROUP BY u.id " +
            "HAVING COUNT(p.id) > 0 " +
            "ORDER BY u.lastName, u.firstName")*/

/*    @Query("SELECT u FROM User u WHERE " +
            "(SELECT COUNT(p) FROM Product p WHERE p.seller.id = u.id AND p.buyer IS NOT NULL) > 0 " +
            "ORDER BY u.lastName, u.firstName")*/

    @Query("SELECT u FROM User u " +
            "JOIN FETCH u.soldProducts p " +
            "WHERE u.soldProducts.size > 0 AND p.buyer IS NOT NULL " +
            "ORDER BY u.lastName, u.firstName")
    List<User> findAllUsersWithBuyerNotNullOrderByLastNameThenByFirstName();

    @Query("SELECT u FROM User u " +
            "JOIN FETCH u.soldProducts p " +
            "WHERE u.soldProducts.size > 0 AND p.buyer IS NOT NULL " +
            "ORDER BY u.soldProducts.size DESC, u.lastName")
    List<User> findAllUsersWithMoreThanOneSoldProductOrderByProductsCountDescThenByLastName();
}
