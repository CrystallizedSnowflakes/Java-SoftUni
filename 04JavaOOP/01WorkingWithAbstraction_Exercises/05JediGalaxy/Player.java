package jediGalaxy;

public class Player {
    private Galaxy galaxy;
    private long points;

    public Player(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public void collectStars(int row, int col){
        while (row >= 0 && col < this.galaxy.getColLength(1)) {
            if (row >= 0 && row < this.galaxy.getLength() && col >= 0 && col < this.galaxy.getColLength(0)) {
                this.points += this.galaxy.getStar(row, col);
            }
            col++;
            row--;
        }
    }

    public long getPoints() {
        return this.points;
    }
}
