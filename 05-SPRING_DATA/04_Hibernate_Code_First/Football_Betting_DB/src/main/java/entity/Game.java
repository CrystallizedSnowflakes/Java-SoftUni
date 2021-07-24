package entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game extends BaseEntity{

    private Team homeTeam;
    private Team awayTeam;
    private Integer homeTeamGoals;
    private Integer awayTeamGoals;
    private LocalDateTime dateTime;
    private Float homeTeamWinBetRate;
    private Float awayTeamWinBetRate;
    private Float drawGameBetRate;
    private Round round;
    private Competition competition;
    private Set<PlayerStatistic> playerStatistics;
    private Set<BetGame> betGames;

    public Game() {
        this.playerStatistics = new HashSet<>();
        this.betGames = new HashSet<>();
    }

    @OneToOne(optional = false)
    @JoinColumn(name = "home_team",referencedColumnName = "id")
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    @OneToOne(optional = true)
    @JoinColumn(name = "away_team",referencedColumnName = "id")
    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Column(name = "home_team_goals", nullable = false, columnDefinition = "INT DEFAULT 0")
    public Integer getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(Integer homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    @Column(name = "away_team_goals", nullable = false, columnDefinition = "INT DEFAULT 0")
    public Integer getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(Integer awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    @Column(name = "date_time")
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Column(name = "home_team_win_bet_rate", nullable = false, columnDefinition = "FLOAT DEFAULT 0")
    public Float getHomeTeamWinBetRate() {
        return homeTeamWinBetRate;
    }

    public void setHomeTeamWinBetRate(Float homeTeamWinBetRate) {
        this.homeTeamWinBetRate = homeTeamWinBetRate;
    }

    @Column(name = "away_team_win_bet_rate", nullable = false, columnDefinition = "FLOAT DEFAULT 0")
    public Float getAwayTeamWinBetRate() {
        return awayTeamWinBetRate;
    }

    public void setAwayTeamWinBetRate(Float awayTeamWinBetRate) {
        this.awayTeamWinBetRate = awayTeamWinBetRate;
    }

    @Column(name = "draw_game_bet_rate", nullable = false, columnDefinition = "FLOAT DEFAULT 0")
    public Float getDrawGameBetRate() {
        return drawGameBetRate;
    }

    public void setDrawGameBetRate(Float drawGameBetRate) {
        this.drawGameBetRate = drawGameBetRate;
    }

    @ManyToOne(optional = false)
    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    @ManyToOne(optional = false)
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    @OneToMany(mappedBy = "game")
    public Set<PlayerStatistic> getPlayerStatistics() {
        return playerStatistics;
    }

    public void setPlayerStatistics(Set<PlayerStatistic> playerStatistics) {
        this.playerStatistics = playerStatistics;
    }

    @OneToMany(mappedBy = "game")
    public Set<BetGame> getBetGames() {
        return betGames;
    }

    public void setBetGames(Set<BetGame> betGames) {
        this.betGames = betGames;
    }
}
