
public class Maze {
    private Tile startingTile;
    private Tile goalTile;
    private Tile bonusTile;
    private Tile[][] tiles;

    public Maze(Tile startingTile, Tile goalTile, Tile bonusTile, int numOfRows, int numOfColumns) {
        this.startingTile = startingTile;
        this.goalTile = goalTile;
        this.bonusTile = bonusTile;
        this.tiles = new Tile[numOfRows][numOfColumns];

    }


    public int getMazeSize() {
        return tiles[0].length * tiles.length;
    }

    public Tile getStartingTile() {
        return startingTile;
    }

    public void setStartingTile(Tile startingTile) {
        this.startingTile = startingTile;
    }

    public Tile getGoalTile() {
        return goalTile;
    }

    public void setGoalTile(Tile goalTile) {
        this.goalTile = goalTile;
    }

    public Tile getBonusTile() {
        return bonusTile;
    }

    public void setBonusTile(Tile bonusTile) {
        this.bonusTile = bonusTile;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }


}
