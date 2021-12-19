// state : tile
// action
// action (tile): List<action>

public class Tile {

    private int x;
    private int y;
    private TileType type;

    private Tile east;
    private Tile south;
    private Tile west;
    private Tile north;

    private boolean visited;


    public Tile(int x, int y, TileType type){
        this.type = type;
        this.x = x;
        this.y = y;
    }

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

    public void setEast(Tile east) {
        this.east = east;
    }

    public void setSouth(Tile south) {
        this.south = south;
    }

    public void setWest(Tile west) {
        this.west = west;
    }

    public void setNorth(Tile north) {
        this.north = north;
    }
    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    
}
