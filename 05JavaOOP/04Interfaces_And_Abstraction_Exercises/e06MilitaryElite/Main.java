package e06MilitaryElite;

import e06MilitaryElite.enums.Corp;
import e06MilitaryElite.enums.State;
import e06MilitaryElite.interfaces.Mission;
import e06MilitaryElite.interfaces.Private;
import e06MilitaryElite.interfaces.Repair;
import e06MilitaryElite.interfaces.Soldier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Soldier> soldiers = new ArrayList<>(); // Soldier is Interface

        String input = reader.readLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            Soldier soldier = null;
            switch (command) {
                case "Private": {
                    double salary = Double.parseDouble(tokens[4]);
                    soldier = new PrivateImpl(id, firstName, lastName, salary);
                    break;
                }
                case "LeutenantGeneral": {
                    double salary = Double.parseDouble(tokens[4]);
                    soldier = new LieutenantGeneralImpl(id, firstName, lastName, salary);
                    for (int i = 5; i < tokens.length; i++) {
                        int currentId = Integer.parseInt(tokens[i]);

                        for (Soldier currentPrivate : soldiers) {
                            if (currentPrivate instanceof Private) {
                                if (currentPrivate.getId() == currentId) {
                                    ((LieutenantGeneralImpl) soldier).addPrivate((Private) currentPrivate);
                                }
                            }
                        }
                    }
                    break;
                }
                case "Engineer": {
                    double salary = Double.parseDouble(tokens[4]);
                    String corps = tokens[5];
                    if (Corp.isValidCorps(corps)) {
                        Corp corpType = Corp.valueOf(corps.toUpperCase());
                        soldier = new EngineerImpl(id, firstName, lastName, salary, corpType);

                        for (int i = 6; i < tokens.length; i += 2) {
                            String repairPart = tokens[i];
                            int repairHours = Integer.parseInt(tokens[i + 1]);
                            Repair repair = new RepairImpl(repairPart, repairHours);
                            ((EngineerImpl) soldier).addRepair(repair);
                        }
                    }
                    break;
                }
                case "Commando": {
                    double salary = Double.parseDouble(tokens[4]);
                    String corp = tokens[5];
                    if (Corp.isValidCorps(corp)) {
                        Corp corpType = Corp.valueOf(corp.toUpperCase());
                        soldier = new CommandoImpl(id, firstName, lastName, salary, corpType);

                        for (int i = 6; i < tokens.length; i += 2) {
                            String missionCodeName = tokens[i];
                            String state = tokens[i + 1];
                            if (State.isValidState(state)) {
                                State missionState = State.valueOf(state.toUpperCase());
                                Mission mission = new MissionImpl(missionCodeName, missionState);
                                ((CommandoImpl) soldier).addMission(mission);
                            }
                        }
                    }
                    break;
                }
                case "Spy": {
                    String codeNumber = tokens[4];
                    soldier = new SpyImpl(id, firstName, lastName, codeNumber);
                    break;
                }
            }
            if (soldier != null) {
                soldiers.add(soldier);
            }
            input = reader.readLine();
        }
        soldiers.forEach(System.out::println);
    }
}