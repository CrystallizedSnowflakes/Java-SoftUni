package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entities.Passenger;

import java.util.List;

@Repository
public interface PassengerRepository  extends JpaRepository<Passenger, Long> {

    Passenger findByEmail(String email);

    @Query("SELECT DISTINCT p FROM Passenger p JOIN FETCH p.tickets t " +
            "ORDER BY size(p.tickets) DESC, p.email")
    List<Passenger> findAllPassengersOrderByTicketsCountDescThenByEmail();

    boolean existsByEmail(String email);
}
