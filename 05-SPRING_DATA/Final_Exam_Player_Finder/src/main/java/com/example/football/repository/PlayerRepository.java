package com.example.football.repository;

import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    boolean existsByEmail(String email);

    @Query("SELECT DISTINCT p FROM Player p JOIN FETCH p.stat s " +
            "WHERE p.birthdate > '1995-01-01' AND p.birthdate < '2003-01-01' " +
            "ORDER BY s.shooting DESC, s.passing DESC, s.endurance DESC, p.lastname")
    List<Player> findBestPlayersAndTheirStats();
}
