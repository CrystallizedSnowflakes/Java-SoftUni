package bg.softuni.javaadvanced;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class E09ParkingSystem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        Map<Integer, HashSet<Integer>> parking = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("stop")){
            String[] parameters = input.split("\\s+");

            int entryRow = Integer.parseInt(parameters[0]);
            int desiredRow = Integer.parseInt(parameters[1]);
            int desiredCol = Integer.parseInt(parameters[2]);

            // Where is parked?
            int parkColumn = 0;

            if (!IsOccupied(parking, desiredRow, desiredCol)){
                parkColumn = desiredCol;
            } else{
                for (int i = 1; i < cols - 1; i++){
                    if (((desiredCol - i) > 0) &&
                            !IsOccupied(parking, desiredRow, (desiredCol - i))){
                        parkColumn = (desiredCol - i);
                        break;
                    } else if (((desiredCol + i) < cols) &&
                            !IsOccupied(parking, desiredRow, (desiredCol + i))){
                        parkColumn = (desiredCol + i);
                        break;
                    }
                }
            }

            if (parkColumn == 0){
                System.out.printf("Row %d full%n", desiredRow);
            }else {
                parking.get(desiredRow).add(parkColumn);
                int steps = Math.abs(entryRow - desiredRow) + 1 + parkColumn;
                System.out.println(steps);
            }
            input = scanner.nextLine();
        }
    }

    private static boolean IsOccupied(Map<Integer, HashSet<Integer>> parking, int row, int col){
        if (parking.containsKey(row)){
            if (parking.get(row).contains(col)){
                return true;
            }
        }else{
            parking.putIfAbsent(row, new HashSet<>());
        }
        return false;
    }
}
