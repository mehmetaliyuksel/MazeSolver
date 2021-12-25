import java.util.*;

public class AStarSearch extends SearchingAlgorithm {
    int a;

    public AStarSearch(Maze maze) {
        super(maze);
        this.frontier = new PriorityQueue<Node>();
        PriorityQueue<Integer> test = new PriorityQueue<Integer>(Collections.reverseOrder());
        test.add(599);
        test.add(0);
        test.add(5);
        test.add(4);
        test.add(80);

        this.a = test.remove();
        initializeSearch();
    }

    @Override
    public void search() {
        System.out.println("---------------------------END OF ABOVE SEARCH ALGORITHM -----------------------");
        PriorityQueue<Node> frontier = (PriorityQueue<Node>) this.frontier;
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