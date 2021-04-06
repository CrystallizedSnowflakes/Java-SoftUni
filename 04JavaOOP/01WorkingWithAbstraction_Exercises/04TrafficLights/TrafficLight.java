package e04TrafficLights;

public class TrafficLight {
    private TrafficLightsState state;

    public TrafficLight(TrafficLightsState initialState){
        this.state = initialState;
    }

    public void update() {
        switch (this.state){
            case RED:
                this.state = TrafficLightsState.GREEN;
                break;
            case YELLOW:
                this.state = TrafficLightsState.RED;
                break;
            case GREEN:
                this.state = TrafficLightsState.YELLOW;
                break;
        }
    }

    @Override
    public String toString() {
        return this.state.name(); // .toString
    }
}
