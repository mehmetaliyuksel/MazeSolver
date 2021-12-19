public class Maze {
    private Tile startingTile;
    private Tile goalTile;
    private Tile[][] tiles;

    public Maze(Tile startingTile, Tile goalTile, Tile[][] tiles) {
        this.startingTile = startingTile;
        this.goalTile = goalTile;
        this.tiles = tiles;
    }

    public int getMazeSize() {
        return tiles[0].length * tiles.length;
    }

}
