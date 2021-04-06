package command;

public class Main {
    /** Command Behavioral Design Pattern

     https://en.wikipedia.org/wiki/Command_pattern

     In Command pattern there is a Command object that encapsulates a request
     by binding together a set of actions on a specific receiver. It does so
     by exposing just one method execute() that causes some actions to be invoked on the receiver. */

    public static void main(String[] args) {

        HeatingSystem heatingSystem = new HeatingSystem();
        heatingSystem.turnOn();

        ICommand heatOn = new HeatingOnCommand();
        ICommand heatOff = new HeatingOffCommand();

        Controller controller = new Controller();
        controller.setCommand(heatOn);
        controller.executeCommand();

        controller.setCommand(heatOff);
        controller.executeCommand();

        heatingSystem.turnOff();
    }
}
