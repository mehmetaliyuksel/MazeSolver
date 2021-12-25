import java.util.*;

public class DepthFirstSearch extends SearchingAlgorithm {

    public DepthFirstSearch(Maze maze) {
        super(maze);
        this.frontier = new Stack<Node>();

        initializeSearch();
    }

    @Override
    public void search() {
        Stack<Node> frontier = (Stack<Node>) this.frontier;

        while (!frontier.isEmpty()) { 
            Node currentNode = frontier.pop();

            explored.add(currentNode.getState());
            
            if (currentNode.isGoal()) {
                printResults(currentNode);
                break;
            }

            //System.out.println(currentNode.getPath());
            currentNode.expand();
            Collections.reverse(currentNode.getChildren());
            addChildrenToFrontier(currentNode);
        }
    }
}