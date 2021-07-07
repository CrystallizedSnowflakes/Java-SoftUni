package bg.codexio.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shampoos")
public class Shampoo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double weight;

    @OneToOne(optional = false) // mandatory ShampooLabel creation first
    private ShampooLabel label;

    @ManyToOne
    //@JoinColumn(name = "batch_id", referencedColumnName = "id")
    private Batch batch;

    @ManyToMany
    @JoinTable(
            name = "shampoos_ingredients",
            joinColumns = @JoinColumn(name = "shamp_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingr_id", referencedColumnName = "id")
    )
    private Set<Ingredient> ingredients;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public ShampooLabel getLabel() {
        return label;
    }

    public void setLabel(ShampooLabel label) {
        this.label = label;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
