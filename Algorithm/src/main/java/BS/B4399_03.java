package BS;


import java.util.Scanner;

//最近热门的冒险大作战海战玩法中，假设目前的海战地图是一个n x n 的矩阵，红色图标代表你的阵营，灰色图标代表的是无人占领的图标 据点是由同一种颜色图标上下左右连接形成的，如果目前你的战力只能打下一个灰色图标，请计算出打下灰色图标之后，能形成据点的图标一共有多少个
//示例1 :
//
//输入: navalBattle= [[1, 0], [0, 1]]
//
//输出: 3
//
//解释: 将一格0变成1，最终连通两个图标得到面积为 3 的据点。
//
//示例 2:
//
//输入: navalBattle = [[1, 1], [1, 0]]
//输出: 4
//解释: 将一格0变成1，据点的面积扩大为 4。
//示例 3:
//
//输入: navalBattle = [[1, 1], [1, 1]]
//输出: 4
//解释: 没有0可以让我们变成1，面积依然为 4。
//
//提示：为了更直观地说明这个问题，让我们使用一个示例二维矩阵来展示。假设我们有以下二维矩阵navalBattle：
//1 1 0 0 0
//1 1 0 0 0
//0 0 1 1 1
//0 0 0 1 1
//在这个二维矩阵中，1表示红色图标，0表示灰色图标。我们的目标是找到最大的据点面积，即连续的红色格子数量。
public class B4399_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入并构造二维数组
        String input = scanner.nextLine().trim();
        int[][] navalBattle = parseInput(input);

        // 计算最大连通块面积
        int maxArea = findMax(navalBattle);
        System.out.println(maxArea);
    }

    // 解析输入字符串，将其转换为二维数组
    public static int[][] parseInput(String input) {
        input = input.replaceAll("\\[", "")   // 去掉所有的左中括号
                .replaceAll("\\]", ""); // 去掉所有的右中括号
        String[] rows = input.split(",");    // 根据逗号分割成多个元素
        int n = (int) Math.sqrt(rows.length);
        int[][] navalBattle = new int[n][n];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                navalBattle[i][j] = Integer.parseInt(rows[index++].trim());
            }
        }

        return navalBattle;
    }

    // 查找最大连通块面积
    public static int findMax(int[][] array) {
        int n = array.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 0) {
                    array[i][j] = 1;
                    boolean[][] visited = new boolean[n][n];
                    max = Math.max(max, dfs(array, visited, i, j));
                    array[i][j] = 0; // 还原
                }
            }
        }

        return max;
    }

    // 深度优先搜索（DFS）用于计算连通块的面积
    public static int dfs(int[][] navalBattle, boolean[][] visited, int i, int j) {
        int n = navalBattle.length;

        // 边界检查和访问检查
        if (i < 0 || i >= n || j < 0 || j >= n || navalBattle[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        int area = 1; // 当前格子贡献的面积

        // 向四个方向进行DFS
        area += dfs(navalBattle, visited, i + 1, j); // 下
        area += dfs(navalBattle, visited, i - 1, j); // 上
        area += dfs(navalBattle, visited, i, j + 1); // 右
        area += dfs(navalBattle, visited, i, j - 1); // 左

        return area;
    }
}
