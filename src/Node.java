import java.util.ArrayList;

public class Node {
    private Node parent;
    private ArrayList<Node> children;
    private Tile state;
    private int depth;
    private int pathCost;
    private boolean visited;

    public Node(Node parent, int depth, Tile state) {
        this.parent = parent;
        this.depth = depth;
        this.state = state;
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

    public void increasePathCost(int cost) {
        this.pathCost += cost;
    }

    public Tile getState() {
        return state;
    }

    public void setState(Tile state) {
        this.state = state;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }


}
