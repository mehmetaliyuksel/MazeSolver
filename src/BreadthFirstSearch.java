import java.util.LinkedList;

public class BreadthFirstSearch extends SearchingAlgorithm {

    public BreadthFirstSearch(Maze maze) {
        super(maze);
        this.frontier = new LinkedList<>();

        initializeSearch();
    }

    @Override
    public void search() {
        LinkedList<Node> frontier = (LinkedList<Node>) this.frontier;

        boolean isFailure = true;
        while (!frontier.isEmpty()) {
            Node currentNode = frontier.remove();

            if (currentNode.isGoal()) {
                printResults(currentNode);
                isFailure = false;
                break;
            }

            explored.add(currentNode.getState());

            currentNode.expand();
            addChildrenToFrontier(currentNode);
        }

        if (isFailure)
            System.out.println("Failure! Could not find the goal state!");
    }

}
