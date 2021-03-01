package jediGalaxy;

public class Main {
    public static void main(String[] args) {
        ConsoleScanner sc = new ConsoleScanner();

        int[] dimensions = InParser.parseArray(sc.readLine(), " ");

        int rows = dimensions[0];
        int cols = dimensions[1];

        Galaxy galaxy = new Galaxy(new Field(new int[rows][cols]));
        Enemy enemy = new Enemy(galaxy);
        Player player = new Player(galaxy);
        Engine engine = new Engine(sc, enemy, player);
        engine.run();

        System.out.println(player.getPoints());
    }
}
