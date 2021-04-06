package e07CollectionHierarchy.models;

import e07CollectionHierarchy.interfaces.AddRemovable;

public class AddRemoveCollection extends Collection implements AddRemovable {

    @Override
    public int add(String item) {
        this.items.add(0, item);
        return 0;
    }

    @Override
    public String remove() {
        int index = this.items.size() - 1;
        // "remove(index)" -> Returns the element that was removed from the list.
        return this.items.remove(index);
    }
}
