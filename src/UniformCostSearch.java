import java.util.PriorityQueue;

public class UniformCostSearch extends SearchingAlgorithm {

    public UniformCostSearch(Maze maze) {
        super(maze);
        this.frontier = new PriorityQueue<>();
        initializeSearch();
    }

    @Override
    public void search() {
        PriorityQueue<Node> frontier = (PriorityQueue<Node>) this.frontier;

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
