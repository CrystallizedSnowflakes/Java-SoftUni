package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission{

    @Override
    public void explore(State state, List<Explorer> explorers) {

        for (int index = 0; index < explorers.size(); index++) {
            Explorer explorer = explorers.get(index);

            for (int st = 0; st < state.getExhibits().size(); st++) {
                String currentState = state.getExhibits().get(st);
                explorer.getSuitcase().getExhibits().add(currentState);
                state.getExhibits().remove(currentState);
                st--;
                explorer.search();
                if (!explorer.canSearch()){
                    explorers.remove(explorer);
                    index--;
                    break;
                }
            }
        }
    }
}
