package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

/** Note: The ControllerImpl class SHOULD NOT handle exceptions! The tests are designed to expect exceptions, not messages! */
public class ControllerImpl implements Controller {

    private Map<Integer, Computer> computers;
    private Map<Integer, Component> components;
    private Map<Integer, Peripheral> peripherals;

    /** The constructor, of the ControllerImpl, does not take any arguments. */
    public ControllerImpl(){
        this.computers = new HashMap<>();
        this.components = new HashMap<>();
        this.peripherals = new HashMap<>();
    }

    /** NOTE: For each command, except for "addComputer" and "buyBest",
     * you must check if a computer, with that id, exists in the computers collection.
     * If it doesn't, throw an IllegalArgumentException with the message "Computer with this id does not exist.". */
    private void checkComputerId(int id){
        if (!this.computers.containsKey(id)){
            /** "Computer with this id does not exist." */
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        /** If a computer, with the same id, already exists in the computers collection,
         * throw an IllegalArgumentException with the message... */
        if (computers.containsKey(id)) {
            /** "Computer with this id already exists." */
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
        /** Creates a computer with the correct type... */
        Computer computer;
        if (computerType.equals("DesktopComputer")){
            computer = new DesktopComputer(id, manufacturer, model, price);
        } else if (computerType.equals("Laptop")){
            computer = new Laptop(id, manufacturer, model, price);
        } else {
            /** If the computer type is invalid,
             * throw an IllegalArgumentException with the message "Computer type is invalid." */
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }
        /** ...and adds it to the collection of computers. */
        computers.put(computer.getId(), computer);
        /** If it's successful, returns "Computer with id {id} added successfully.". */
        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model,
                               double price, double overallPerformance, int generation) {
        checkComputerId(computerId);
        /** If a component, with the same id, already exists in the components collection,
         * throws an IllegalArgumentException with the message... */
        if (components.containsKey(id)) {
            /** "Component with this id already exists." */
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }
        /** Creates a component with the correct type and... */
        Component component;
        switch (componentType){
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                /** If the component type is invalid,
                 * throws an IllegalArgumentException with the message "Component type is invalid." */
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }
        /** and adds it to the computer with that id,...*/
        computers.get(computerId).addComponent(component);
        /** then adds it to the collection of components in the controller. */
        components.put(component.getId(), component);
        /** If it's successful, returns
         * "Component {component type} with id {component id} added successfully in computer with id {computer id}.". */
        return String.format(ADDED_COMPONENT, componentType, component.getId(), computerId);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer,
                                String model, double price, double overallPerformance, String connectionType) {
        checkComputerId(computerId);
        /** If a peripheral, with the same id, already exists in the peripherals collection,
         * it throws an IllegalArgumentException with the message... */
        if (peripherals.containsKey(id)){
            /**"Peripheral with this id already exists." */
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }
        /** Creates a peripheral, with the correct type, and...*/
        Peripheral peripheral;
        switch (peripheralType){
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                /** If the peripheral type is invalid,
                 * throws an IllegalArgumentException with the message "Peripheral type is invalid." */
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }
        /** ...adds it to the computer with that id,...*/
        computers.get(computerId).addPeripheral(peripheral);
        /** ...then adds it to the collection of peripherals in the controller.*/
        peripherals.put(peripheral.getId(), peripheral);
        /** If it's successful,
         * it returns "Peripheral {peripheral type} with id {peripheral id} added successfully in computer with id {computer id}.". */
         return String.format(ADDED_PERIPHERAL, peripheralType, peripheral.getId(), computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        checkComputerId(computerId);
        /** Removes a component, with the given type from the computer with that id,... */
        Component component = computers.get(computerId).removeComponent(componentType);
        /** ...then removes component from the collection of components. */
        components.remove(component.getId());
        /** If it's successful, it returns "Successfully removed {component type} with id {component id}." */
        return String.format(REMOVED_COMPONENT, componentType, component.getId());
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        checkComputerId(computerId);
        /** Removes a peripheral, with the given type from the computer with that id,.. */
        Peripheral peripheral = computers.get(computerId).removePeripheral(peripheralType);
        /** ...then removes the peripheral from the collection of peripherals. */
        peripherals.remove(peripheral.getId());
        /** If it's successful, it returns "Successfully removed {peripheral type} with id { peripheral id}." */
        return String.format(REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
    }

    @Override
    public String buyComputer(int id) {
        checkComputerId(id);
        /** Removes a computer, with the given id, from the collection of computers. */
        Computer computer = computers.remove(id);
        /** If it's successful, it returns toString method on the removed computer. */
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        /** Removes the computer with the highest overall performance and
         * with a price, less or equal to the budget, from the collection of computers. */

        Computer computer = computers.values().stream()
                .filter(c -> c.getPrice() <= budget) // Predicate -> returns the elements that matches the condition if true
                .max(Comparator.comparing(Computer::getOverallPerformance))
                .orElse(null);

        /** If there are not any computers in the collection or
         * the budget is insufficient for any computer,
         * throws an IllegalArgumentException with the message "Can't buy a computer with a budget of ${budget}." */
        if (computer == null){
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }

        computers.remove(computer.getId());

        /** If it's successful, it returns toString method on the removed computer. */
         return computer.toString();
    }

    @Override
    public String getComputerData(int id) {
        checkComputerId(id);
        /** If it's successful, it returns toString method on the computer with the given id. */
        return computers.get(id).toString();
    }
}
