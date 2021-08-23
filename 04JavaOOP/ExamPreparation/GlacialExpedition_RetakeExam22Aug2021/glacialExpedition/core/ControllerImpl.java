package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.models.suitcases.Suitcase;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;
    private int exploredStatesCount;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
        this.exploredStatesCount = 0;
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        switch (type){
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }
        this.explorerRepository.add(explorer);
        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        List<String> exhibitsList = Arrays.asList(exhibits);
        State state = new StateImpl(stateName);
        state.getExhibits().addAll(exhibitsList);
        this.stateRepository.add(state);
        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorerByName = this.explorerRepository.byName(explorerName);
        if (explorerByName == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        this.explorerRepository.remove(explorerByName);
        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        List<Explorer> explorersAboveFiftyEnergy = this.explorerRepository.getCollection().stream()
                .filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());
        if (explorersAboveFiftyEnergy.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        int countBeforeMission = explorersAboveFiftyEnergy.size();
        State stateByName = this.stateRepository.byName(stateName);
        Mission mission = new MissionImpl();
        mission.explore(stateByName, explorersAboveFiftyEnergy);
        exploredStatesCount++;
        int countAfterMission = explorersAboveFiftyEnergy.size();
        int retiredExplorers = countBeforeMission - countAfterMission;
        return String.format(ConstantMessages.STATE_EXPLORER, stateName, retiredExplorers);
    }

    @Override
    public String finalResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED, exploredStatesCount));
        sb.append(System.lineSeparator());
        sb.append(ConstantMessages.FINAL_EXPLORER_INFO);
        sb.append(System.lineSeparator());
        for (Explorer explorer : this.explorerRepository.getCollection()) {
            sb.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, explorer.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, explorer.getEnergy()));
            sb.append(System.lineSeparator());

            Suitcase suitcase = explorer.getSuitcase();
            if (suitcase.getExhibits().isEmpty()){
                sb.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
            } else {
                String collectedItems = String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, suitcase.getExhibits());
                sb.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, collectedItems));
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
