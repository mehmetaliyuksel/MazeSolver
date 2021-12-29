public class Main {

    public static void main(String[] args) {
        IOManager ioManager = new IOManager("Example_Input.txt");
        Maze maze = ioManager.readFile();
        BreadthFirstSearch bfs = new BreadthFirstSearch(maze);
        bfs.search();
        System.out.println("-----------------------------------------------------------------------------------------");
        DepthFirstSearch dfs = new DepthFirstSearch(maze);
        dfs.search();
        System.out.println("-----------------------------------------------------------------------------------------");
        UniformCostSearch ucs = new UniformCostSearch(maze);
        ucs.search();
        System.out.println("-----------------------------------------------------------------------------------------");
        IterativeDeepeningSearch ids = new IterativeDeepeningSearch(maze);
        ids.search();
        System.out.println("-----------------------------------------------------------------------------------------");
        GreedyBestFirstSearch gbs = new GreedyBestFirstSearch(maze);
        gbs.search();
        System.out.println("-----------------------------------------------------------------------------------------");
        AStarSearch ass = new AStarSearch(maze);
        ass.search();
    }
}
