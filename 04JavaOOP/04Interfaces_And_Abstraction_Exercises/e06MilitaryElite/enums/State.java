package e06MilitaryElite.enums;

public enum State {
    INPROGRESS("inProgress"),
    FINISHED("Finished");

    private String state;

    State(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public static boolean isValidState(String state) {
        return state.equals(INPROGRESS.getState()) || state.equals(FINISHED.getState());
    }
}
