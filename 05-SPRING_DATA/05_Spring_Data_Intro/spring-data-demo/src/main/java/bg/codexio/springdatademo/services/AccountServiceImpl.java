package bg.codexio.springdatademo.services;

import bg.codexio.springdatademo.exceptions.InsufficientFundsException;
import bg.codexio.springdatademo.models.Account;
import bg.codexio.springdatademo.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional // org.springframework.transaction
    public void transferBetweenAccounts(Long fromId, Long toId, BigDecimal amount) throws InsufficientFundsException {
        this.withdrawMoney(amount, fromId);
        this.transferMoney(amount, toId);

/*        var from = this.getAccount(fromId);
        throwInsufficientFundsException(from, amount);
        from.setBalance(from.getBalance().subtract(amount));

        var to = this.getAccount(toId);
        to.setBalance(to.getBalance().add(amount));*/
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long id) throws InsufficientFundsException {
        Account account = this.getAccount(id);
        throwInsufficientFundsException(account, amount);

        account.setBalance(account.getBalance().subtract(amount));
        this.accountRepository.save(account);
    }

    @Override
    public void transferMoney(BigDecimal amount, Long id) {
        Account account = this.getAccount(id);
        account.setBalance(account.getBalance().add(amount));
        this.accountRepository.save(account);

    }

    private Account getAccount(Long id) {
        return this.accountRepository.findById(id).orElseThrow();
    }

    private void throwInsufficientFundsException(Account account, BigDecimal amount) throws InsufficientFundsException {
        if (account.getBalance().compareTo(amount) < 0){
            throw new InsufficientFundsException();
        }
    }
}
