package e07CollectionHierarchy.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private final int MAX_SIZE = 100;

    protected List<String> items;

    protected Collection() {
        this.items = new ArrayList<>(MAX_SIZE);
    }
}
