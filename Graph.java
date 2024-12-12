import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<List<Integer>> adjList;
    int numNodes;

    public Graph(int n) {
        numNodes = n;
        adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public int degree(int node) {
        return adjList.get(node).size();
    }
}
