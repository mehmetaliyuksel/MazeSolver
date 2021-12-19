import java.util.*;

public class BreadthFirstSearch {
    private Maze maze;
    private Queue<Node> frontier;
    private Set<Node> explored;
    private StringBuilder optimalPath;

    public BreadthFirstSearch(Maze maze) {
        this.frontier = new LinkedList<Node>();
        this.maze = maze;
    }

    public void search(Node node) {
        while (!frontier.isEmpty()) {
            Node currentNode = frontier.remove();
            currentNode.setVisited(true);
            generateChildren(currentNode);
            addChildrenToFrontier(currentNode);

            optimalPath.append("(" + currentNode.getState().getX() + "," + currentNode.getState().getY() + ") - ");

            calculateCost(currentNode);
            if (currentNode.getState().getType().equals(TileType.GOAL)) {
                break;
            }

        }

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
        if (currentNode.getState().getType().equals(TileType.BONUS))
            currentNode.increasePathCost(-8);
        else
            currentNode.increasePathCost(1);

    }

    private void initializeSearch() {
        Node rootNode = new Node(null, 0, maze.getStartingTile());
        rootNode.setVisited(true);
        frontier.add(rootNode);
    }

}
