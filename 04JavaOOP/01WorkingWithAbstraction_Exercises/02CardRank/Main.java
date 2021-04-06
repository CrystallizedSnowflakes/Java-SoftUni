package e02CardRank;

public class Main {
    public static void main(String[] args) {
        CardRank[] values = CardRank.values();

        StringBuilder sb = new StringBuilder("Card Ranks:").append(System.lineSeparator());
        for (CardRank value : values) {
            sb.append(String.format("Ordinal value: %d; Name value: %s", value.ordinal(), value)) // value.name()
                    .append(System.lineSeparator());
        }
        System.out.println(sb.toString().trim());
    }
}
