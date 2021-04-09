package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.COMPUTER_COMPONENTS_TO_STRING;
import static onlineShop.common.constants.OutputMessages.COMPUTER_PERIPHERALS_TO_STRING;

public abstract class BaseComputer extends BaseProduct implements Computer{

    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    /** Override the base functionality (if the components collection is empty, |=> avgComponentsPerformance = 0
     * it should return only the computer overall performance, |=> super.getOverallPerformance() + 0
     * otherwise return the sum of the computer overall performance and
     * the average overall performance from all components)*/ //=> super.getOverallPerformance() + avgComponentsPerformance(!=0);
    @Override
    public double getOverallPerformance() {
        double avgComponentsPerformance = components.stream()
                .mapToDouble(Component::getOverallPerformance)
                .average()
                .orElse(0);
        return super.getOverallPerformance() + avgComponentsPerformance;
    }

    /** Override the base functionality (The price is equal to
     * the total sum of the computer price with |=> super.getPrice()
     * the sum of all component prices and |=> sumOfAllComponentsPrices
     * the sum of all peripheral prices)*/ //=> sumOfAllPeripheralPrices
    @Override
    public double getPrice() {
        double sumOfAllComponentsPrices = components.stream()
                .mapToDouble(Component::getPrice)
                .sum();
        double sumOfAllPeripheralPrices = peripherals.stream()
                .mapToDouble(Peripheral::getPrice)
                .sum();
        return super.getPrice() + sumOfAllComponentsPrices + sumOfAllPeripheralPrices;
    }

    /** If the components collection contains a component with the same component type,
     * throw an IllegalArgumentException*/
    @Override
    public void addComponent(Component component) {
        if (components.stream().anyMatch(c -> c.getClass() == component.getClass())){
            /** "Component {component type} does not exist in {computer type} with Id {id}." */
            throw new IllegalArgumentException(
                    String.format(EXISTING_COMPONENT,
                    component.getClass().getSimpleName(),
                    this.getClass().getSimpleName(), // I'm in class BaseComputer
                    this.getId())); //I'm in class BaseComputer
        }
        /**Otherwise add the component in the components collection.*/
        this.components.add(component);
    }

    /** If the components collection is empty or
     * does not have a component of that type,
     * throw an IllegalArgumentException*/
    @Override
    public Component removeComponent(String componentType) {
        if (components.stream().noneMatch(c -> c.getClass().getSimpleName().equals(componentType))){
            /** "Component %s does not exist in %s with Id %d." */
            throw new IllegalArgumentException(
                    String.format(NOT_EXISTING_COMPONENT,
                    componentType,
                    this.getClass().getSimpleName(), // I'm in class BaseComputer
                    this.getId())); //I'm in class BaseComputer
        }

        /** Otherwise remove the component of that type and return it. */
        int index = 0;
        for (int i = 0; i < components.size(); i++) {
            Component component = components.get(i);
            if (component.getClass().getSimpleName().equals(componentType)){
                index = i;
                break;
            }
        }
        return components.remove(index);
    }

    /** If the peripherals collection contains a peripheral with the same peripheral type,
     * throw an IllegalArgumentException with the message...*/
    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (peripherals.stream().anyMatch(p -> p.getClass() == peripheral.getClass())){
            /** "Peripheral {peripheral type} already exists in {computer type} with Id {id}." */
            throw new IllegalArgumentException(
                    String.format(EXISTING_PERIPHERAL,
                    peripheral.getClass().getSimpleName(),
                    this.getClass().getSimpleName(),
                    this.getId()));
        }
        this.peripherals.add(peripheral);
    }

    /** If the peripherals collection is empty or
     * does not have a peripheral of that type,
     * throw an IllegalArgumentException with the message...*/
    @Override
    public Peripheral removePeripheral(String peripheralType) {
        if (peripherals.stream().noneMatch(p -> p.getClass().getSimpleName().equals(peripheralType))) {
            /** "Peripheral {peripheral type} does not exist in {computer type} with Id {id}." */
            throw new IllegalArgumentException(
                    String.format(NOT_EXISTING_PERIPHERAL,
                            peripheralType,
                            this.getClass().getSimpleName(), // I'm in class BaseComputer
                            this.getId())); //I'm in class BaseComputer
        }
        /** Otherwise remove the peripheral of that type and return it. */
        int index = 0;
        for (int i = 0; i < peripherals.size(); i++) {
            Peripheral peripheral = peripherals.get(i);
            if (peripheral.getClass().getSimpleName().equals(peripheralType)){
                index = i;
                break;
            }
        }
        return peripherals.remove(index);
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public String toString() {
        /** "Overall Performance: {overall performance}. Price: {price} - {product type}: {manufacturer} {model} (Id: {id})" */
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator());

        /** " Components ({components count}):" */
        sb.append(String.format(" " + COMPUTER_COMPONENTS_TO_STRING, getComponents().size()));

        for (Component component : components) {
            /**"  {component one}"
               "  {component two}"
               "  {component n}" */
            sb.append(System.lineSeparator()).append("  ").append(component.toString());
        }
        sb.append(System.lineSeparator());

        /** " Peripherals ({peripherals count}); Average Overall Performance ({average overall performance peripherals}):" */
        sb.append(String.format(" " + COMPUTER_PERIPHERALS_TO_STRING,
                getPeripherals().size(),
                peripherals.stream()
                .mapToDouble(Peripheral::getOverallPerformance)
                .average()
                .orElse(0)));

        for (Peripheral peripheral : peripherals) {
            /** "  {peripheral one}"
                "  {peripheral two}"
                "  {peripheral n}" */
            sb.append(System.lineSeparator()).append("  ").append(peripheral.toString());
        }

        return sb.toString().trim();
    }
}
