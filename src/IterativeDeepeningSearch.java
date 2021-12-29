import java.util.Collections;
import java.util.Stack;

public class IterativeDeepeningSearch extends SearchingAlgorithm {

    public IterativeDeepeningSearch(Maze maze) {
        super(maze);
        this.frontier = new Stack<>();

        initializeSearch();
    }

    @Override
    public void search() {
        Stack<Node> frontier = (Stack<Node>) this.frontier;

        boolean isFailure = true;
        IDS:
        for (int depth = 1; ; depth++) {
            explored.clear();
            frontier.clear();
            initializeSearch();
            
            while (!frontier.isEmpty()) {
                Node currentNode = frontier.pop();

                if (currentNode.isGoal()) {
                    printResults(currentNode);
                    isFailure = false;
                    break IDS;
                }

                explored.add(currentNode.getState());

                if (currentNode.getDepth() == depth) // if limit depth reached then cut the tree and continue with sibling
                    continue;

                currentNode.expand();
                Collections.reverse(currentNode.getChildren()); // To obtain stack order
                addChildrenToFrontier(currentNode);
            }
        }

        if (isFailure)
            System.out.println("Failure! Could not find the goal state!");
    }
}