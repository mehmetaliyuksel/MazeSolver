import java.util.*;

public class IterativeDeepeningSearch extends SearchingAlgorithm {

    public IterativeDeepeningSearch(Maze maze) {
        super(maze);
        this.frontier = new Stack<>();

        initializeSearch();
    }

    @Override
    public void search() {
        Stack<Node> frontier = (Stack<Node>) this.frontier;

        IDS:
        for (int depth = 1; ; depth++) {
            explored.clear();
            frontier.clear();
            initializeSearch();
            
            while (!frontier.isEmpty()) {
                Node currentNode = frontier.pop();

                explored.add(currentNode.getState());

                if (currentNode.isGoal()) {
                    printResults(currentNode);
                    break IDS;
                }

                if (currentNode.getDepth() == depth) // if limit depth reached then cut the tree and continue with sibling
                    continue;

                currentNode.expand();
                Collections.reverse(currentNode.getChildren()); // To obtain stack order 
                addChildrenToFrontier(currentNode);
            }
        }
    }
}