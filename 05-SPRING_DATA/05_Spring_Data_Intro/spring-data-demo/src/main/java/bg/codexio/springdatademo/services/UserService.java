package bg.codexio.springdatademo.services;

import bg.codexio.springdatademo.exceptions.UserNotFoundException;
import bg.codexio.springdatademo.exceptions.UsernameAlreadyExistsException;

import java.math.BigDecimal;

public interface UserService {

    void register(String username,
                  int age,
                  BigDecimal initialAmount
    ) throws UsernameAlreadyExistsException;

    void addAccount(BigDecimal amount, long id) throws UserNotFoundException;
}
