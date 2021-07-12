package bg.codexio.springdatademo.repositories;

import bg.codexio.springdatademo.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    /*
    JpaRepository Type parameters:
    <T> – the domain type the repository manages (Account)
    <ID> – the type of the id of the entity the repository manages (Long)

    The JpaRepository interface contains methods like:

•	save(E entity)
•	findOne(Id primaryKey)
•	findAll()
•	count()
•	delete(E entity)
•	exists(Id primaryKey)
    */
}
