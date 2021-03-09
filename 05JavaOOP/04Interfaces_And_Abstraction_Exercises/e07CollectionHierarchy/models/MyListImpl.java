package e07CollectionHierarchy.models;

import e07CollectionHierarchy.interfaces.MyList;

public class MyListImpl extends Collection implements MyList {

    @Override
    public int add(String item) {
        this.items.add(0, item);
        return 0;
    }

    @Override
    public String remove() {
        // remove & return the first element in the collection
        return this.items.remove(0);
    }

    @Override
    public int getUsed() {
        return this.items.size();
    }
}
