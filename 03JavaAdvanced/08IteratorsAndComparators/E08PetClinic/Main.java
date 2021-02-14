package E08PetClinic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            switch (tokens[0]){
                case "Create":
                    if (tokens[1].equals("Pet")){
                        String petName = tokens[2];
                        int petAge = Integer.parseInt(tokens[3]);
                        String kind = tokens[4];
                        Pet pet = new Pet(petName, petAge, kind);
                        pets.putIfAbsent(petName, pet);
                    } else {
                        try {
                            String clinicName = tokens[2];
                            int rooms = Integer.parseInt(tokens[3]);
                            Clinic clinic = new Clinic(clinicName, rooms);
                            clinics.putIfAbsent(clinicName, clinic);
                        } catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Add":
                    String petName = tokens[1];
                    String clinicName = tokens[2];
                    Pet pet = pets.get(petName);
                    Clinic clinic = clinics.get(clinicName);
                    System.out.println(clinic.add(pet));
                    break;
                case "Release":
                    clinicName = tokens[1];
                    Clinic cl = clinics.get(clinicName);
                    System.out.println(cl.release());
                    break;
                case "HasEmptyRooms":
                    clinicName = tokens[1];
                    System.out.println(clinics.get(clinicName).hasEmptyRooms());
                    break;
                case "Print":
                    clinicName = tokens[1];
                    Clinic c = clinics.get(clinicName);
                    if (tokens.length == 2){
                        // print each room in the specified clinic
                        for (Pet p : c.getPets()) {
                            if (p == null){
                                System.out.println("Room empty");
                            } else {
                                System.out.println(p.toString());
                            }
                        }
                    } else {
                        int room = Integer.parseInt(tokens[2]);
                        c.printClinicRoomInfo(room);
                    }
                    break;
            }
        }
    }
}
