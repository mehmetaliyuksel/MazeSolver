import java.util.Collections;
import java.util.Stack;

public class DepthFirstSearch extends SearchingAlgorithm {

    public DepthFirstSearch(Maze maze) {
        super(maze);
        this.frontier = new Stack<Node>();

        initializeSearch();
    }

    @Override
    public void search() {
        Stack<Node> frontier = (Stack<Node>) this.frontier;

        boolean isFailure = true;
        while (!frontier.isEmpty()) { 
            Node currentNode = frontier.pop();

            if (currentNode.isGoal()) {
                printResults(currentNode);
                isFailure = false;
                break;
            }

            explored.add(currentNode.getState());

            currentNode.expand();
            Collections.reverse(currentNode.getChildren());
            addChildrenToFrontier(currentNode);
        }

        if (isFailure)
            System.out.println("Failure! Could not find the goal state!");
    }
}