import java.util.*;

public class BreadthFirstSearch extends SearchingAlgorithm {

    public BreadthFirstSearch(Maze maze) {
        super(maze);
        this.frontier = new LinkedList<Node>();
        initializeSearch();
    }

    public void search() {
        while (!frontier.isEmpty()) {
            Node currentNode = frontier.remove();
            currentNode.getState().setVisited(true);
            currentNode.increasePathCost(1);

            if (currentNode.isGoal()) {
                printResults(currentNode);
                break;
            }
            System.out.println(currentNode.getPath());
            currentNode.expand();
            addChildrenToFrontier(currentNode);
        }
    }

    private void addChildrenToFrontier(Node currentNode) {
        ArrayList<Node> children = currentNode.getChildren();
        for (Node child : children) {
            if (!child.getState().isVisited())
                frontier.add(child);
        }
    }
}
