package sf;

import java.util.Arrays;

public class E1636 {
    public int[] frequencySort(int[] nums) {
        // 1. 统计出现频率
        int[] count = new int[201];
        for (int i : nums) {
            count[i + 100]++;
        }
        // 2. 比较器 按频率升序、再按数值降序

        //如果返回值是-1，表示两个数并不需要交换位置，a在b前面
        //如果返回值是1， 表示两个数需要交换欸之，b在a前面

        return Arrays.stream(nums).boxed().sorted((a, b) -> {
            int af = count[a + 100];
            int bf = count[b + 100];
            if (af < bf) {
                return -1;
            } else if (af > bf) {
                return 1;
            } else {
                return b - a;
            }
        }).mapToInt(Integer::intValue).toArray();
    }

}
