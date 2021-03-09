package e07CollectionHierarchy.models;

import e07CollectionHierarchy.interfaces.Addable;

public class AddCollection extends Collection implements Addable {

    @Override
    public int add(String item) {
        this.items.add(item);
        return this.items.size() - 1;
    }
}
