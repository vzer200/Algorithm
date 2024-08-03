package sf;

public class E560 {
    //和为k的子数组
    public static int subarraySum(int[] nums, int k) {

        //利用前缀和求解

        int len = nums.length;
        int[] pre = new int[len+1];
        pre[0] = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            pre[i+1] = pre[i]+nums[i];
        }

        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                //左右边界
                if (pre[right+1]-pre[left]==k){
                    count++;
                }

            }
        }
        return count;
    }

    public static void subarraySum2(int[] nums, int k) {
        //优化前缀和 加入哈希表 缩小时间复杂度

    }



    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        subarraySum(nums, 2);
    }
}
