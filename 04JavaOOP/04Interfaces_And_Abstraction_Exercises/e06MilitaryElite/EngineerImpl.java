package e06MilitaryElite;

import e06MilitaryElite.enums.Corp;
import e06MilitaryElite.interfaces.Engineer;
import e06MilitaryElite.interfaces.Repair;

import java.util.ArrayList;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;


    public EngineerImpl(int id, String firstName, String lastName, double salary, Corp corpType) {
        super(id, firstName, lastName, salary, corpType);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append("Repairs:");

        this.repairs.forEach(repair -> {
            sb.append(System.lineSeparator());
            sb.append("  ").append(repair.toString());
        });

        return sb.toString();
    }
}
