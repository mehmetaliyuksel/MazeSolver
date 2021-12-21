import java.util.*;

public abstract class SearchingAlgorithm {
    private Maze maze;
    protected Collection<Node> frontier;
    protected HashSet<Tile> explored;
    private int maxSizeOfFrontier;

    public abstract void search();

    public SearchingAlgorithm(Maze maze) {
        this.maze = maze;
        this.explored = new HashSet<Tile>();
        Node.numOfExpandedNodes = 0;
        this.maxSizeOfFrontier = 1;
    }

    protected void initializeSearch() {
        Node rootNode = new Node(null, 0, maze.getStartingTile());
        explored.add(rootNode.getState());
        frontier.add(rootNode);
    }

    protected void printResults(Node node) {
        System.out.println("Searching algorithm: " + this.getClass().getName());
        System.out.println("Path Cost: " + node.getPathCost());
        System.out.println("Number of expanded nodes: " + Node.numOfExpandedNodes);
        System.out.println("The maximum size of the explored set: " + explored.size());
        System.out.println("The maximum size of the frontier: " + this.maxSizeOfFrontier);
        System.out.println("Path: " + node.getPath());
    }

    public void addChildrenToFrontier(Node currentNode) {
        ArrayList<Node> children = currentNode.getChildren();

        for (Node child : children) {
            if (!explored.contains(child.getState())) {
                child.increasePathCost();
                frontier.add(child);
               
                
            }
        }

        updateMaxSizeOfFrontier();
    }

    private void updateMaxSizeOfFrontier() {
        int size = frontier.size();

        if (size > maxSizeOfFrontier)
            maxSizeOfFrontier = size;
    }

}