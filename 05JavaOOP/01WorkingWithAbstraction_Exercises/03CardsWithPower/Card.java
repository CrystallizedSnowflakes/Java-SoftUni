package e03CardsWithPower;

public class Card {

    private CardRank number;
    private CardSuit color;
    private int power;

    public Card(CardRank number, CardSuit color) {
        this.number = number;
        this.color = color;
        calculatePower();
    }

    private int calculatePower() {
        return this.power = number.getPower() + color.getPower();
    }

    @Override
    public String toString() {

        return String.format("Card name: %s of %s; Card power: %d",
                this.number,
                this.color,
                this.power);
    }
}
