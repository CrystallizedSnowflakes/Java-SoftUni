package jediGalaxy;

public class Engine {
    private ConsoleScanner sc;
    private Enemy enemy;
    private Player player;
    private String command;

    public Engine(ConsoleScanner sc, Enemy enemy, Player player){
        this.sc = sc;
        this.enemy = enemy;
        this.player = player;
        this.command = "";
    }

    public void run(){
        this.command = this.sc.readLine();
        while (!command.equals("Let the Force be with you")) {

            int[] playerPosition = InParser.parseArray(this.command, " ");
            int[] enemyPosition = InParser.parseArray(this.sc.readLine(), " ");

            int enemyRow = enemyPosition[0];
            int enemyCol = enemyPosition[1];

            this.enemy.destroyStars(enemyRow, enemyCol);

            int playerRow = playerPosition[0];
            int playerCol = playerPosition[1];

            this.player.collectStars(playerRow, playerCol);
            this.command = this.sc.readLine();
        }
    }
}
