public class Maze {
    private Tile startingTile;
    private Tile goalTile;
    private Tile bonusTile;
    private Tile[][] tiles;

    public Maze(Tile startingTile, Tile goalTile, Tile bonusTile, int numOfRows, int numOfColumn) {
        this.startingTile = startingTile;
        this.goalTile = goalTile;
        this.bonusTile = bonusTile;
        this.tiles = new Tile[numOfRows][numOfColumn];
    }

    public int getMazeSize() {
        return tiles[0].length * tiles.length;
    }

}
