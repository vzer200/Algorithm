package BS;

import java.util.*;

public class xm_02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] array = new int[n];
        int sum = 0;

        // 计算数组总和
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
            sum += array[i];
        }

        // 如果当前和已经是 x 的倍数，输出 0
        if(sum % x == 0){
            System.out.println(0);
            return;
        }

        // 使用 BFS 进行搜索
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(new int[]{sum, 0}); // 初始状态：和与操作次数
        visited.add(sum);

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentSum = current[0];
            int steps = current[1];

            // 尝试移除一个元素
            for(int i = 0; i < n; i++) {
                int newSum = currentSum - array[i];
                if(newSum % x == 0) {
                    System.out.println(steps + 1);
                    return;
                }
                if(!visited.contains(newSum)) {
                    visited.add(newSum);
                    queue.offer(new int[]{newSum, steps + 1});
                }
            }

            // 尝试对每个元素加一
            for(int i = 0; i < n; i++) {
                int newSum = currentSum + 1;
                if(newSum % x == 0) {
                    System.out.println(steps + 1);
                    return;
                }
                if(!visited.contains(newSum)) {
                    visited.add(newSum);
                    queue.offer(new int[]{newSum, steps + 1});
                }
            }
        }

        // 如果无法使和成为 x 的倍数
        System.out.println(n); // 可能需要移除所有元素
    }

}
