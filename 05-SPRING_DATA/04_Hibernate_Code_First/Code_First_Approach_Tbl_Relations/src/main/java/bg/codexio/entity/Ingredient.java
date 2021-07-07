package bg.codexio.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Ingredient {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private Set<Shampoo> shampoos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
