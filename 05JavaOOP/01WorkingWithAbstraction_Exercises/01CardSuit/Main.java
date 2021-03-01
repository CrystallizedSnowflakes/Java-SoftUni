package e01CardSuit;

public class Main {
    public static void main(String[] args) {

        CardSuit[] values = CardSuit.values();

        StringBuilder sb = new StringBuilder("Card Suits:").append(System.lineSeparator());
        for (CardSuit value : values) {
            sb.append(String.format("Ordinal value: %d; Name value: %s", value.ordinal(), value)) // value.name()
                    .append(System.lineSeparator());
        }
        System.out.println(sb.toString().trim());
    }
}
