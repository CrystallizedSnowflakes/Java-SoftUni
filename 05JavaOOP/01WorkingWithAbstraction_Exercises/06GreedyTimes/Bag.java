package e06greedyTimes;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Bag {
    private final long capacity;
    private long currentBagQuantity;
    // Gold
    private int totalGoldQuantity;
    boolean isGoldAdded;
    // Gems
    private int totalGemsQuantity;
    private final HashMap<String, Long> gems;
    // Cash
    private int totalCashQuantity;
    private final HashMap<String, Long> cash;

    public Bag(long capacity){
        this.capacity = capacity;
        this.currentBagQuantity = 0;
        this.totalGoldQuantity = 0;
        this.totalGemsQuantity = 0;
        this.totalCashQuantity = 0;
        this.gems = new HashMap<>();
        this.cash = new HashMap<>();
        this.isGoldAdded = false;
    }

    private boolean hasFreeCapacity(long quantity){
        return this.currentBagQuantity + quantity <= this.capacity;
    }

    public void addGold(long quantity){
        if (hasFreeCapacity(quantity)) {
            this.totalGoldQuantity += quantity;
            this.currentBagQuantity += quantity;
            this.isGoldAdded = true;
        }
    }

    public void addGem(String gem, long quantity){
        if (hasFreeCapacity(quantity) && totalGemsQuantity + quantity <= this.totalGoldQuantity){
            this.gems.putIfAbsent(gem, 0L);
            this.gems.put(gem, this.gems.get(gem) + quantity);

            this.totalGemsQuantity += quantity;
            this.currentBagQuantity += quantity;
        }
    }

    public void addCash(String currency, long quantity){
        if (hasFreeCapacity(quantity) && totalCashQuantity + quantity <= this.totalGemsQuantity){
            this.cash.putIfAbsent(currency, 0L);
            this.cash.put(currency, this.cash.get(currency) + quantity);

            this.totalCashQuantity += quantity;
            this.currentBagQuantity += quantity;
        }
    }

    private long getTotalCash(){
        return this.cash.values().stream().mapToLong(e -> e).sum();
    }

    private long getTotalGems(){
        return this.gems.values().stream().mapToLong(e -> e).sum();
    }

    private Comparator<Map.Entry<String, Long>> getComparator(){
        return (f, s) -> {
            int result = s.getKey().compareTo(f.getKey()); // by item in descending order
            if (result == 0){
                result = f.getValue().compareTo(s.getValue()); // by quantity in ascending order
            }
            return result;
        };
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        // gold
        if (isGoldAdded) {
            sb.append(String.format("<Gold> $%d", this.totalGoldQuantity)).append(System.lineSeparator());
            sb.append(String.format("##Gold - %d", this.totalGoldQuantity)).append(System.lineSeparator());
        }
        // gems
        if (!gems.isEmpty()) {
            sb.append(String.format("<Gem> $%d", getTotalGems())).append(System.lineSeparator());
            this.gems.entrySet().stream()
                    .sorted(getComparator())
                    .forEach(entry ->
                            sb.append(String.format("##%s - %d", entry.getKey(), entry.getValue()))
                                    .append(System.lineSeparator()));
        }
        // cash
        if (!cash.isEmpty()) {
            sb.append(String.format("<Cash> $%d", getTotalCash())).append(System.lineSeparator());
            this.cash.entrySet().stream()
                    .sorted(getComparator())
                    .forEach(entry ->
                            sb.append(String.format("##%s - %d", entry.getKey(), entry.getValue()))
                                    .append(System.lineSeparator()));
        }
        return sb.toString().trim();
    }
}
