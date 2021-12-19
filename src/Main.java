public class Main {

    public static void main(String[] args) {
        IOManager ioManager = new IOManager("input.txt", "output.txt");
        Maze maze = ioManager.readFile();
        System.out.println(maze);
        BreadthFirstSearch bfs = new BreadthFirstSearch(maze);
        bfs.search();
    }
}
