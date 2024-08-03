package BS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZJ_02 {

    private static List<List<Integer>> list = new ArrayList<>();
    private static char[] colors;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 节点数量
        colors = new char[n + 1]; // 记录每个节点的颜色
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            list.get(u).add(v);
            list.get(v).add(u); // 无向图
        }
        dfs(1, '0', '0'); // 从1号节点开始，初始没有父节点和祖父节点的颜色
        for (int i = 1; i <= n; i++) {
            System.out.print(colors[i]);
        }

    }

    public static void dfs(int node, char parentColor, char gParentColor) {
        char nodeColor = 'R'; // 默认颜色

        // 如果和父节点或祖父节点颜色相同，则改变
        if (nodeColor == parentColor || nodeColor == gParentColor) {
            nodeColor = 'G';
        }
        if (nodeColor == parentColor || nodeColor == gParentColor) {
            nodeColor = 'B';
        }
        colors[node] = nodeColor;
        // 遍历子节点

        for (int child : list.get(node)) {
            if (colors[child] == 0) {
                dfs(child, nodeColor, parentColor);
            }
        }
    }

}
