package BS;

public class qqmusic_03 {
}
class Solution {

    public static int minArrayWeight(int[] nums, int m) {
        int n = nums.length;
        // 初始权值
        int initialWeight = 0;
        for (int i = 1; i < n; i++) {
            initialWeight += Math.abs(nums[i] - nums[i - 1]);
        }

        int minWeight = initialWeight;

        // 考虑将所有数字分散插入
        for (int i = 1; i <= m; i++) {
            // 插入后的新权值
            int newWeight = 0;
            for (int j = 1; j < n; j++) {
                int weight = Math.abs(nums[j] - nums[j - 1]);
                if (j == 1) {
                    weight = Math.min(weight, Math.abs(nums[j - 1] - i) + Math.abs(i - nums[j]));
                }
                newWeight += weight;
            }
            newWeight += Math.min(Math.abs(nums[0] - 1), Math.abs(nums[n - 1] - m));
            minWeight = Math.min(minWeight, newWeight);
        }

        return minWeight;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int m1 = 3;
        System.out.println(minArrayWeight(nums1, m1));  // Output: 4

        int[] nums2 = {1, 2, 3, 4, 5};
        int m2 = 6;
        System.out.println(minArrayWeight(nums2, m2));  // Output: 5
    }
}