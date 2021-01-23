package bg.softuni.javaadvanced;

import java.util.Scanner;

public class E08TheHeiganDance2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int playersPoints = 18500;
        double heiganPoints = 3000000;

        double damageOverHeigan = Double.parseDouble(scanner.nextLine());

        int[]playerPos = new int[2];
        playerPos[0] = 7;
        playerPos[1] = 7;

        boolean isInCloud = false;
        String lastSpell = "";

        while (playersPoints > 0){
            heiganPoints -= damageOverHeigan;

            if (isInCloud){
                playersPoints -= 3500;
                isInCloud = false;
            }

            if (playersPoints <= 0){
                lastSpell = "Cloud";
                break;
            }

            if (heiganPoints <= 0) {
                break;
            }

            String[] tokens = scanner.nextLine().split("\\s+");
            String spell = tokens[0];
            int hitRowOverPlayer = Integer.parseInt(tokens[1]);
            int hitColOverPlayer = Integer.parseInt(tokens[2]);
            lastSpell = spell;

            boolean isPlayerDamaged = checkIfPlayerIsDamaged(playerPos[0], playerPos[1], hitRowOverPlayer, hitColOverPlayer);

            int damageOverPlayer = 0;
            if (isPlayerDamaged) {
                switch (spell) {
                    case "Cloud":
                        damageOverPlayer = 3500;
                        break;
                    case "Eruption":
                        damageOverPlayer = 6000;
                        break;
                }

                boolean canMove = playerCanMoveAndHeMoved(playerPos, hitRowOverPlayer, hitColOverPlayer);

                if (!canMove) {
                    playersPoints -= damageOverPlayer;
                    if (spell.equals("Cloud")){
                        isInCloud = true;
                    }
                }
            }
        }

        if (heiganPoints <= 0) {
            System.out.println("Heigan: Defeated!");
        }else {
            System.out.printf("Heigan: %.2f%n", heiganPoints);
        }

        if (playersPoints <= 0){
            lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : lastSpell;
            System.out.printf("Player: Killed by %s%n", lastSpell);
        } else {
            System.out.printf("Player: %d%n", playersPoints);
        }
        System.out.printf("Final position: %d, %d", playerPos[0], playerPos[1]);
    }

    private static boolean playerCanMoveAndHeMoved(int[] playerPosition, int hitRowOverPlayer, int hitColOverPlayer) {
        boolean canMove = true;
        // Up Right Down Left
        int r = playerPosition[0];
        int c = playerPosition[1];
            // CENTER
        if (r == hitRowOverPlayer && c == hitColOverPlayer){
            canMove = false;
            //UP
        } else if(isInBounds(r - 1,  c)
                && !checkIfPlayerIsDamaged(r - 1, c, hitRowOverPlayer, hitColOverPlayer)){
            r--;
            // RIGHT
        } else if (isInBounds(r, c + 1)
                && !checkIfPlayerIsDamaged(r, c + 1, hitRowOverPlayer, hitColOverPlayer)){
            c++;
            // DOWN
        } else if (isInBounds(r + 1, c)
                && !checkIfPlayerIsDamaged(r + 1, c,  hitRowOverPlayer, hitColOverPlayer)){
            r++;
            // LEFT
        } else if (isInBounds(r, c - 1)
               && !checkIfPlayerIsDamaged(r, c - 1, hitRowOverPlayer, hitColOverPlayer)){
            c--;
        } else {
            canMove = false;
        }
        playerPosition[0] = r;
        playerPosition[1] = c;

        return  canMove;
    }

    private static boolean isInBounds(int row, int col) {
        return  row >= 0 && row < 15 && col >= 0 && col < 15;
    }

    private static boolean checkIfPlayerIsDamaged(int playerRow, int playerCol, int hitRowOverPlayer, int hitColOverPlayer) {
        // -66-|-67-|-68-
        // -76-|-77-|-78-
        // -86-|-87-|-88-
        return playerRow >= hitRowOverPlayer - 1
                && playerRow <= hitRowOverPlayer + 1
                && playerCol >= hitColOverPlayer - 1
                && playerCol <= hitColOverPlayer + 1;
    }
}
