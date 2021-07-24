package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BetGameKey implements Serializable {

    private Long gameId;
    private Long betId;

    public BetGameKey() {
    }

    @Column(name = "game_id")
    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    @Column(name = "bet_id")
    public Long getBetId() {
        return betId;
    }

    public void setBetId(Long betId) {
        this.betId = betId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BetGameKey that = (BetGameKey) o;
        return Objects.equals(gameId, that.gameId) && Objects.equals(betId, that.betId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, betId);
    }
}
