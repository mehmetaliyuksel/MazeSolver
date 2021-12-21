import java.util.*;

public class IterativeDeepeningSearch extends SearchingAlgorithm {

    public IterativeDeepeningSearch(Maze maze) {
        super(maze);
        this.frontier = new Stack<Node>();

        initializeSearch();
    }

    // @Override
    // public void search() {
    //     Stack<Node> frontier = (Stack<Node>) this.frontier;

    //     int depth = 1;
    //     while (!frontier.isEmpty()) {
    //         Node currentNode = frontier.pop();
    //         explored.add(currentNode.getState());
    //         DepthLimitedSearch(currentNode, depth);

    //         if (currentNode.getDepth() == depth)
    //             break;

    //         // System.out.println(currentNode.getPath());
    //         currentNode.expand();
    //         addChildrenToFrontier(currentNode);
    //         depth++;
    //     }

    // }

    public void search() {
        Stack<Node> frontier = (Stack<Node>) this.frontier;
        IDS:
        for (int depth = 0; ; depth++) {
            System.out.println("**********DEPTH************" + depth);
            explored.clear();// = new HashSet<Tile>();
            frontier.clear();// = new Stack<Node>();
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

                System.out.println(currentNode.getPath());
                currentNode.expand();
                Collections.reverse(currentNode.getChildren());
                addChildrenToFrontier(currentNode);
            }
        }
    }

    // private Node DepthLimitedSearch(Node currentNode, int limit) {

    //     if (currentNode.isGoal()) {
    //         return currentNode;
    //     } else if (currentNode.getDepth() == limit) {
    //         return null;
    //     } else {

    //         for (Node child : currentNode.getChildren()) {
    //             Node result = DepthLimitedSearch(child, limit);

    //             if (!Objects.isNull(result))
    //                 return result;
    //         }
    //     }

    //     return null;
    // }
}