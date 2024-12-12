import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Backtracking algorithm
        MISUsingBackTrackAlgorithm backTrack = new MISUsingBackTrackAlgorithm();
        Set<Integer> MIS = backTrack.findMIS(graph);

        System.out.println("Maximum Independent Set (Backtracking):");
        System.out.println(MIS);
        System.out.println("Size: " + MIS.size());
        System.out.println("=============================End BackTracking algorithm=============================");

        // Greedy algorithm
        MISUsingGreedyAlgorithm greedy = new MISUsingGreedyAlgorithm();
        Set<Integer> MIS1 = greedy.findMIS(graph);

        System.out.println("Maximum Independent Set (Greedy):");
        System.out.println(MIS1);
        System.out.println("Size: " + MIS1.size());
        System.out.println("=============================End Greedy algorithm=============================");
    }
}