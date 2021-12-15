

public class Tile {

    private final int x;
    private final int y;
    private final TileType type;

    private final Tile east;
    private final Tile south;
    private final Tile west;
    private final Tile north;

    public Tile(int x, int y, TileType type, Tile east, Tile south, Tile west, Tile north) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.east = east;
        this.south = south;
        this.west = west;
        this.north = north;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TileType getType() {
        return type;
    }

    public Tile getEast() {
        return east;
    }

    public Tile getSouth() {
        return south;
    }

    public Tile getWest() {
        return west;
    }

    public Tile getNorth() {
        return north;
    }
}
