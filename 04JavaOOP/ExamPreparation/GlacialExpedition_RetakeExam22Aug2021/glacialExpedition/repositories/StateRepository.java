package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StateRepository implements Repository<State>{

    private Collection<State> states;

    public StateRepository() {
        this.states = new ArrayList<>();
    }

    @Override
    public Collection<State> getCollection() {
        return Collections.unmodifiableCollection(this.states);
    }

    @Override
    public void add(State entity) {
        if (this.states.stream().noneMatch(s -> s.getName().equals(entity.getName()))) {
            this.states.add(entity);
        }
    }

    @Override
    public boolean remove(State entity) {
        return this.states.remove(entity);
    }

    @Override
    public State byName(String name) {
        return this.states.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }
}
