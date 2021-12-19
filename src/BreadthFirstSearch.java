import java.util.*;

public class BreadthFirstSearch {
    private Maze maze;
    private Queue<Node> frontier;
    private Set<Node> explored;
    private int totalCost;
    private String optimalPath;

    public BreadthFirstSearch(Maze maze) {
        this.frontier = new LinkedList<Node>();
        this.maze = maze;
    }

    public void search(Node node) {
        totalCost = 0;
        while (!frontier.isEmpty()) {
            Node currentNode = frontier.remove();
            currentNode.setVisited(true);
            optimalPath += ("(" + currentNode.getState().getX() + "," + currentNode.getState().getY() + ") - ");
            calculateCost(currentNode);
            if(currentNode.getState().getType().equals(TileType.GOAL)) {
                break;
            }
            generateChildren(currentNode);
            addChildrenToFrontier(currentNode);
        }
        System.out.println("The cost of the solution found is : " + totalCost);
    }

    private void generateChildren(Node currentNode) {
        Tile nextState = currentNode.getState().getEast();
        addChildrenIfAvailable(currentNode, nextState);

        nextState = currentNode.getState().getSouth();
        addChildrenIfAvailable(currentNode, nextState);

        nextState = currentNode.getState().getWest();
        addChildrenIfAvailable(currentNode, nextState);

        nextState = currentNode.getState().getNorth();
        addChildrenIfAvailable(currentNode, nextState);

    }

    private void addChildrenIfAvailable(Node currentNode, Tile nextState) {
        if (!Objects.isNull(nextState)) {
            Node child = new Node(currentNode, currentNode.getDepth() + 1, nextState);
            currentNode.getChildren().add(child);
        }
    }

    private void addChildrenToFrontier(Node currentNode) {
        ArrayList<Node> children = currentNode.getChildren();
        for (Node child : children) {
            if (!child.isVisited())
                frontier.add(child);
        }

    }

    private void calculateCost(Node currentNode) {
        if ( currentNode.getState().getType().equals(TileType.BONUS))
        {
            totalCost += -8;
        } else {
            totalCost += 1;
        }
    }

    private void initializeSearch() {
        Node rootNode = new Node(null, 0, maze.getStartingTile());
        rootNode.setPathCost(0);
        rootNode.setVisited(true);
        frontier.add(rootNode);
    }

    public int costCalculation() {
        return 0;
    }
}
