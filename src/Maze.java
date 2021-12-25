import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Maze {
    private Tile startingTile;
    private Tile[][] tiles;
    private List<Tile> goalTiles;

    public Maze(Tile startingTile, List<Tile> goalTiles, Tile[][] tiles) {
        this.startingTile = startingTile;
        this.tiles = tiles;
        this.goalTiles = goalTiles;

        getTilesAs1DList()
                .forEach(tile -> tile.setManhattanDistanceToNearestGoal(goalTiles));
    }

    public List<Tile> getGoalTiles() {
        return goalTiles;
    }

    public int getMazeSize() {
        return tiles[0].length * tiles.length;
    }

    public Tile getStartingTile() {
        return startingTile;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    private List<Tile> getTilesAs1DList() {
        return Arrays.stream(this.tiles) // 'tiles' is two-dimensional
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
