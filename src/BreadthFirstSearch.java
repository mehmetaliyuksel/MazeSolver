import java.util.*;

public class BreadthFirstSearch extends SearchingAlgorithm {

    public BreadthFirstSearch(Maze maze) {
        super(maze);
        this.frontier = new LinkedList<Node>();

        initializeSearch();
    }

    @Override
    public void search() {
        LinkedList<Node> frontier = (LinkedList<Node>) this.frontier;

        while (!frontier.isEmpty()) { 
            Node currentNode = frontier.remove();

            explored.add(currentNode.getState());

            if (currentNode.isGoal()) {
                printResults(currentNode);
                break;
            }

            System.out.println(currentNode.getPath());
            currentNode.expand();
            addChildrenToFrontier(currentNode);
        }
    }

}
