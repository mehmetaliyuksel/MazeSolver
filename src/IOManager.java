import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOManager {

    private final String inputFile;
    private final String outputFile;

    public IOManager(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public Maze readFile() {
        try {
            FileInputStream fis = new FileInputStream(inputFile);
            Scanner scanner = new Scanner(fis);

            String[] firstLine = scanner.nextLine().split(",");
            int numOfRows = Integer.parseInt(firstLine[0]);
            int numOfColumns = Integer.parseInt(firstLine[1]);

            Tile[][] tiles = new Tile[numOfRows][numOfColumns];
            List<Tile> goalTiles = new ArrayList<Tile>();
            Tile startingTile = null;
            boolean isWestReachableForCurrentTile, isNorthReachableForCurrentTile, isEastReachableForWestTile = false;
            boolean[] isSouthReachableForNorthTiles = new boolean[numOfColumns];

            int rowCounter = 0;
            int columnCounter = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tileString = line.split(",");
                TileType tileType = TileType.valueOf(tileString[4]);
                isWestReachableForCurrentTile = Boolean.parseBoolean(tileString[2]);
                isNorthReachableForCurrentTile = Boolean.parseBoolean(tileString[3]);

                Tile currentTile = new Tile(columnCounter + 1, rowCounter + 1, tileType);
                tiles[rowCounter][columnCounter] = currentTile;
                
                if (tileType == TileType.STARTING)
                    startingTile = currentTile;
                else if (tileType == TileType.GOAL)
                    goalTiles.add(currentTile);

                if (columnCounter != 0) {
                    Tile westTile = tiles[rowCounter][columnCounter - 1];
                    if (isEastReachableForWestTile)
                        westTile.setEast(currentTile);
                    if (isWestReachableForCurrentTile)
                        currentTile.setWest(westTile);
                }
                if (rowCounter != 0) {
                    Tile northTile = tiles[rowCounter - 1][columnCounter];
                    if (isSouthReachableForNorthTiles[columnCounter])
                        northTile.setSouth(currentTile);
                    if (isNorthReachableForCurrentTile)
                        currentTile.setNorth(northTile);
                }

                isEastReachableForWestTile = Boolean.parseBoolean(tileString[0]);
                isSouthReachableForNorthTiles[columnCounter] = Boolean.parseBoolean(tileString[1]);
                columnCounter++;
                if (columnCounter == numOfColumns) {
                    columnCounter = 0;
                    rowCounter++;
                }
            }
            scanner.close();
            return new Maze(startingTile, goalTiles, tiles);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
            return null;
        }
    }
}
