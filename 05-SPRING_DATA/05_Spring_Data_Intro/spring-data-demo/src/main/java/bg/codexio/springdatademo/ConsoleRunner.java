package bg.codexio.springdatademo;

import bg.codexio.springdatademo.exceptions.InsufficientFundsException;
import bg.codexio.springdatademo.exceptions.UsernameAlreadyExistsException;
import bg.codexio.springdatademo.services.AccountService;
import bg.codexio.springdatademo.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConsoleRunner implements CommandLineRunner {

    private final UserService userService;
    private final AccountService accountService;

    public ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            this.accountService.transferBetweenAccounts(2L, 4L, new BigDecimal(500));
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }

/*        try {
            this.userService.register("Pesho", 25, new BigDecimal(1000L));
        } catch (UsernameAlreadyExistsException ex){
            System.out.println(ex.getClass().getSimpleName());
        }

        this.userService.addAccount(new BigDecimal(750),1);

        try {
            this.accountService.withdrawMoney(new BigDecimal(1200), 1L);
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }

        this.accountService.transferMoney(new BigDecimal(200), 2L);*/
    }
}
