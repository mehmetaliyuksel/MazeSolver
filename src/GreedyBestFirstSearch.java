import java.util.PriorityQueue;

public class GreedyBestFirstSearch extends SearchingAlgorithm {

    public GreedyBestFirstSearch(Maze maze) {
        super(maze);
        this.frontier = new PriorityQueue<>();
        initializeSearch();
    }

    @Override
    public void search(){
        PriorityQueue<Node> frontier = (PriorityQueue<Node>) this.frontier;
        while (!frontier.isEmpty()) {
            Node currentNode = frontier.remove();

            explored.add(currentNode.getState());

            if (currentNode.isGoal()) {
                printResults(currentNode);
                break;
            }

            currentNode.expand();
            addChildrenToFrontier(currentNode);
        }
    }

}