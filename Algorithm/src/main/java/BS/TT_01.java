package BS;

import java.util.*;

public class TT_01 {

    // 方法：找到最长的组合路径
    public static String LongestBehaviorPath(String[] paths) {
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> allNodes = new HashSet<>();
        Set<String> startNodes = new HashSet<>();

        // 构建图
        for (String path : paths) {
            String[] nodes = path.split("->");
            allNodes.addAll(Arrays.asList(nodes));
            for (int i = 0; i < nodes.length - 1; i++) {
                graph.computeIfAbsent(nodes[i], k -> new ArrayList<>()).add(nodes[i + 1]);
                startNodes.add(nodes[i + 1]);
            }
        }

        // 找到起点
        allNodes.removeAll(startNodes);
        String startNode = allNodes.isEmpty() ? "" : allNodes.iterator().next();

        // 计算最长路径
        List<String> longestPath = new ArrayList<>();
        dfs(graph, startNode, new ArrayList<>(), longestPath);

        return String.join("->", longestPath);
    }

    private static void dfs(Map<String, List<String>> graph, String node, List<String> path, List<String> longestPath) {
        path.add(node);
        if (path.size() > longestPath.size()) {
            longestPath.clear();
            longestPath.addAll(path);
        }
        if (graph.containsKey(node)) {
            for (String next : graph.get(node)) {
                dfs(graph, next, path, longestPath);
            }
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        // 输入的用户路径
        String[] pathsArray = {"A->B->C", "C->D->E", "B->C->F", "E->G"};
        // 调用方法计算最长路径
        String longestPath = LongestBehaviorPath(pathsArray);
        System.out.println("最长路径: " + longestPath);
    }
}
