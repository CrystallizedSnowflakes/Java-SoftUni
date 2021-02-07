package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player){
        if (this.capacity > this.roster.size()){
            roster.add(player);
        }
    }

    public boolean removePlayer(String name){
        return roster.removeIf(player -> player.getName().equals(name));
    }

    public void promotePlayer(String name){
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
                return;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                player.setRank("Trial");
                return;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz){
        Player[] kicked = this.roster.stream()
                .filter(player -> player.getClazz().equals(clazz))
                .toArray(Player[]::new);

        this.roster = this.roster.stream().filter(player -> !player.getClazz().equals(clazz))
                .collect(Collectors.toList());

        return kicked;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder("Players in the guild: ")
                .append(this.name).append(":");
        this.roster.forEach(player -> sb.append(System.lineSeparator()).append(player));
        return sb.toString();
    }
}
