package DemoTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class MonkeyEatPeaches {

    private static void eatPeaches(int peaches, List<List<Integer>> results, List<Integer> current, int step) {
        if (peaches == 0) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (peaches - i >= 0) {

                // 当前这只猴子选择吃 i 个桃子
                current.add(i);
                // 继续下一轮选择
                eatPeaches(peaches - i, results, current, step + 1);
                // 回溯到这一步
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int peaches = 10;  // 总共有10个桃子
        List<List<Integer>> results = new ArrayList<>();

        eatPeaches(peaches, results, new ArrayList<>(), 0);

        // 打印出所有吃法
        System.out.println("所有可能的吃桃方法：" + results.size());
        for (List<Integer> way : results) {
            System.out.println(way);
        }
    }
}