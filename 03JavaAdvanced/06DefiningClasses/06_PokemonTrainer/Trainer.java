package pokemonTrainer_06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trainer {
    private String name;
    private int badges;
    private Map<String, List<Pokemon>> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.setPokemons();
    }

    public int getBadges() {
        return badges;
    }

    private void setPokemons() {
        this.pokemons = new HashMap<>();
        this.pokemons.put("Fire", new ArrayList<>());
        this.pokemons.put("Water", new ArrayList<>());
        this.pokemons.put("Electricity", new ArrayList<>());
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.putIfAbsent(pokemon.getElement(), new ArrayList<>());
        this.pokemons.get(pokemon.getElement()).add(pokemon);
    }

    public boolean hasElementType(String element) {
        return this.pokemons.get(element).size() != 0;
        //return !this.pokemons.get(element).isEmpty();
    }

    public void increaseBadges(int increment) {
        this.badges += increment;
    }

    public void damagePokemons(int damage) {
        for (List<Pokemon> pokemonsList : pokemons.values()) {
            for (Pokemon pokemon : pokemonsList) {
                pokemon.takeDamage(damage);
            }
        }
        this.clearDeathPokemons();
    }

    private void clearDeathPokemons(){
        for (List<Pokemon> pokemonsList : pokemons.values()) {
            pokemonsList.removeIf(p -> p.getHealth() <= 0);
        }
    }

    public int getPokemonsCount(){
        int size = 0;
        for (List<Pokemon> pokemonsList : pokemons.values()) {
            size += pokemonsList.size();
        }
        return size;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.getPokemonsCount());
    }
}
