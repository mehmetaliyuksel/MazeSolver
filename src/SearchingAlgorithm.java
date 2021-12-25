import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public abstract class SearchingAlgorithm {
    private final Maze maze;
    protected Collection<Node> frontier;
    protected HashSet<Tile> explored;
    private int maxSizeOfFrontier;
    private int insertionCounter;

    public abstract void search();

    public SearchingAlgorithm(Maze maze) {
        this.maze = maze;
        this.explored = new HashSet<>();
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
        System.out.println("The cost of the solution: " + node.getActualPathCost());
        System.out.println("The number of expanded nodes: " + Node.numOfExpandedNodes);
        System.out.println("The maximum size of the frontier: " + this.maxSizeOfFrontier);
        System.out.println("The maximum size of the explored set: " + explored.size());
        System.out.println("The solution path: " + node.getPath());
    }

    public void addChildrenToFrontier(Node currentNode) {
        ArrayList<Node> children = currentNode.getChildren();

        for (Node child : children) {
            if (!explored.contains(child.getState())) {
                child.increasePathCost(this.getClass().getName());
                child.setInsertionTimeStamp(this.insertionCounter++);
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