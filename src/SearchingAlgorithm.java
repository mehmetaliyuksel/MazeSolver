import java.util.*;

public abstract class SearchingAlgorithm {
    private Maze maze;
    protected Queue<Node> frontier;

    public abstract void search();

    public SearchingAlgorithm(Maze maze) {
        this.maze = maze;
        Node.numOfExpandedNodes = 0;
    }

    protected void initializeSearch() {
        Node rootNode = new Node(null, 0, maze.getStartingTile());
        rootNode.getState().setVisited(true);
        frontier.add(rootNode);
    }

    protected void printResults(Node node) {
        System.out.println("Searching algorithm: " + this.getClass().getName());
        System.out.println("Path Cost: " + node.getPathCost());
        System.out.println("Path: " + node.getPath());
        System.out.println("Number of expanded nodes: " + Node.numOfExpandedNodes);
    }

}