import java.util.ArrayList;
import java.util.Objects;

public class Node implements Comparable<Node> {

    private static final int TRAP_COST = 10;
    private static final int STEP_COST = 1;

    public static int numOfExpandedNodes;

    private Node parent;
    private ArrayList<Node> children;
    private Tile state;
    private int depth;
    private int actualPathCost;
    private int estimatedPathCost;

    public Node(Node parent, int depth, Tile state) {
        this.parent = parent;
        this.depth = depth;
        this.state = state;
        this.children = new ArrayList<>();
    }

    public String getPath() {
        Node node = this;
        ArrayList<String> path = new ArrayList<>();
        while (!Objects.isNull(node)) {
            path.add("(" + node.getState().getX() + "," + node.getState().getY() + ")");
            node = node.getParent();
        }
        StringBuilder builder = new StringBuilder();
        for (int i = path.size() - 1; i >= 0; i--) {
            builder.append(path.get(i));
        }
        return builder.toString();
    }

    public void increasePathCost(String searchingAlgorithm) {
        if (!Objects.isNull(parent)) {
            increaseActualPathCost();

            if (searchingAlgorithm.equals(GreedyBestFirstSearch.class.getName()))
                this.estimatedPathCost = this.getState().getManhattanDistanceToNearestGoal();
            else if (searchingAlgorithm.equals(AStarSearch.class.getName()))
                this.estimatedPathCost = this.actualPathCost + this.getState().getManhattanDistanceToNearestGoal();
            else
                this.estimatedPathCost = this.actualPathCost;
        }
    }

    private void increaseActualPathCost() {
        int pathCost = 0;
        if (state.getType().equals(TileType.TRAP))
            pathCost = parent.getActualPathCost() + TRAP_COST;
        else
            pathCost = parent.getActualPathCost() + STEP_COST;
        this.actualPathCost = pathCost;
    }

    public void expand() {
        numOfExpandedNodes++;

        Tile nextState = this.getState().getEast();
        this.addChildrenIfAvailable(nextState);

        nextState = this.getState().getSouth();
        this.addChildrenIfAvailable(nextState);

        nextState = this.getState().getWest();
        this.addChildrenIfAvailable(nextState);

        nextState = this.getState().getNorth();
        this.addChildrenIfAvailable(nextState);

    }

    private void addChildrenIfAvailable(Tile nextState) {
        if (!Objects.isNull(nextState)) {
            Node child = new Node(this, this.getDepth() + 1, nextState);
            this.getChildren().add(child);
        }
    }

    public int getActualPathCost() {
        return actualPathCost;
    }

    public boolean isGoal() {
        return state.getType().equals(TileType.GOAL);
    }

    public Tile getState() {
        return state;
    }

    public void setState(Tile state) {
        this.state = state;
    }

    public int getEstimatedPathCost() {
        return estimatedPathCost;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public int compareTo(Node node) {
        if (this.estimatedPathCost < node.estimatedPathCost)
            return -1;
        else if (this.estimatedPathCost > node.estimatedPathCost)
            return 1;
        // else if (this.getParent().equals(getParent())) {
        //     if (this.whereAmI() < node.whereAmI())
        //         return -1;
        //     else if (this.whereAmI() > node.whereAmI())
        //         return 1;
            
        //     return 0;
        //     }
        else 
            return 0;
    }

    // public int whereAmI() {
    //     if (this.getParent().getState().getEast() == this.getState())
    //         return 4;
    //     else if (this.getParent().getState().getSouth() == this.getState())
    //         return 3;
    //     else if (this.getParent().getState().getWest() == this.getState())
    //         return 2;
    //     else
    //         return 1;
    // }

}
