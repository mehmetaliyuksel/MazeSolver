import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Maze {
    private final Tile startingTile;
    private final Tile[][] tiles;

    public Maze(Tile startingTile, List<Tile> goalTiles, Tile[][] tiles) {
        this.startingTile = startingTile;
        this.tiles = tiles;

        getTilesAs1DList()
                .forEach(tile -> tile.setManhattanDistanceToNearestGoal(goalTiles));
    }

    public Tile getStartingTile() {
        return startingTile;
    }

    private List<Tile> getTilesAs1DList() {
        return Arrays.stream(this.tiles) // 'tiles' is two-dimensional
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
