package entity;

import javax.persistence.*;

@Entity
@Table(name = "player_statistics")
public class PlayerStatistic {

    private PlayerStatisticKey id;
    private Game game;
    private Player player;
    private Integer scoredGoals;
    private Integer playerAssists;
    private Integer playedMinutes;

    public PlayerStatistic() {
    }

    @EmbeddedId
    public PlayerStatisticKey getId() {
        return id;
    }

    public void setId(PlayerStatisticKey id) {
        this.id = id;
    }

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name = "game_id")
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @ManyToOne
    @MapsId("playerId")
    @JoinColumn(name = "player_id")
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Column(name = "scored_goals", nullable = false, columnDefinition = "int default 0")
    public Integer getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(Integer scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    @Column(name = "player_assists", nullable = false, columnDefinition = "int default 0")
    public Integer getPlayerAssists() {
        return playerAssists;
    }

    public void setPlayerAssists(Integer playerAssists) {
        this.playerAssists = playerAssists;
    }

    @Column(name = "played_minutes", nullable = false)
    public Integer getPlayedMinutes() {
        return playedMinutes;
    }

    public void setPlayedMinutes(Integer playedMinutes) {
        this.playedMinutes = playedMinutes;
    }
}
