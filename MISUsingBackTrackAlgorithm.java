import java.util.HashSet;
import java.util.Set;

public class MISUsingBackTrackAlgorithm {

    // Hàm kiểm tra nếu đỉnh có thể thêm vào tập S
    public static boolean isIndependent(int node, Set<Integer> S, Graph graph) {
        for (int neighbor : graph.adjList.get(node)) {
            if (S.contains(neighbor)) {
                return false;
            }
        }
        return true;
    }

    // Hàm chính để tìm Tập Độc Lập Cực Đại
    public Set<Integer> findMIS(Graph graph) {
        return findMISHelper(graph, new HashSet<>(), 0);
    }

    private Set<Integer> findMISHelper(Graph graph, Set<Integer> currentSet, int currentNode) {
        if (currentNode >= graph.numNodes) {
            return new HashSet<>(currentSet);
        }

        // Trường hợp 1: Không thêm đỉnh hiện tại
        Set<Integer> withoutCurrent = findMISHelper(graph, currentSet, currentNode + 1);

        // Trường hợp 2: Thêm đỉnh hiện tại nếu có thể
        Set<Integer> withCurrent = new HashSet<>(currentSet);
        if (isIndependent(currentNode, currentSet, graph)) {
            withCurrent.add(currentNode);
            withCurrent = findMISHelper(graph, withCurrent, currentNode + 1);
        }

        // Trả về tập lớn hơn
        return withCurrent.size() > withoutCurrent.size() ? withCurrent : withoutCurrent;
    }
}