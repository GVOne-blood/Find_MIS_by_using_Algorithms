import java.util.*;

public class MISUsingGreedyAlgorithm {
    public Set<Integer> findMIS(Graph graph) {
        Set<Integer> mis = new HashSet<>();
        boolean[] visited = new boolean[graph.numNodes];
        
        // Sắp xếp các đỉnh theo bậc tăng dần
        List<Integer> vertexList = new ArrayList<>();
        for (int i = 0; i < graph.numNodes; i++) {
            vertexList.add(i);
        }
        vertexList.sort(Comparator.comparingInt(graph::degree));
        
        for (int vertex : vertexList) {
            if (!visited[vertex]) {
                mis.add(vertex);
                visited[vertex] = true;
                for (int neighbor : graph.adjList.get(vertex)) {
                    visited[neighbor] = true;
                }
            }
        }
        
        return mis;
    }
}