package entity;

import javax.persistence.*;

@Entity
@Table(name = "bet_games")
public class BetGame {

    private BetGameKey id;
    private Bet bet;
    private Game game;
    private ResultPrediction resultPrediction;

    public BetGame() {
    }

    @EmbeddedId
    public BetGameKey getId() {
        return id;
    }

    public void setId(BetGameKey id) {
        this.id = id;
    }

    @ManyToOne
    @MapsId("betId")
    @JoinColumn(name = "bet_id")
    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "result_prediction", referencedColumnName = "id")
    public ResultPrediction getResultPrediction() {
        return resultPrediction;
    }

    public void setResultPrediction(ResultPrediction resultPrediction) {
        this.resultPrediction = resultPrediction;
    }
}
