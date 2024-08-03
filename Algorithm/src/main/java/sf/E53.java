package sf;

import java.util.Arrays;

public class E53 {

   /* public static int maxSubArray(int[] nums) {

        int begin = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        int res;
        int len = nums.length;
        while (begin < len) {
            res = sumArr(nums, begin, end);
            if (res<max){
                //如果小 左边弹出
                begin++;
            }else {

                max = res;
            }

            if (end==len-1){
                break;
            }
                end++;
        }
        return max;
    }


    public static int sumArr(int[] nums, int begin, int end) {

        int res = 0;
        for (int i = begin; i <= end; i++) {
            res += nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int begin = 0;
        int end = nums.length - 1;
        int i = sumArr(nums, begin, end);
    //    System.out.println(i);
        int i1 = maxSubArray(nums);
        System.out.println(i1);
    }*/



    public int maxSubArray(int[] nums) {
        //动态规划的思想
        //你要求连续子序列的最大值
        //首先 得是连续子序列 不可重排序
        //求最大值 max取最大值不可少
        //再看这道题 其实跟原来的思路差不多 也是一个区间一个区间的试探
        //如果当前区间的值已经小于或者等于0了 你继续往后扩大区间也没有意义了 因当前区间必不可能是最大值区间 因为有负数带来的减益
        //如果当前区间的值大于 就可以继续向后进行叠加 扩大区间的范围 并用res记录下当前区间的值与后序区间的值进行比较
        //那么第一种情况（小于0） 就只能把前面的begin进行加
        //动态规划就是用数组记录当前的每一个情况的值
        //用在此题上就是用数组记录当前区间的最大值

        //动态规划
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            if (dp[i]>max)
                max = dp[i];
        }
        return max;
    }



    public static int maxSubArray2(int[] nums) {
        int num = 0;
        int res = Integer.MIN_VALUE;
        int min =0;
        for(int a: nums){
            num+=a;

            res = Math.max(res,num-min);
            min = Math.min(min,num);

        }


        return res;
    }

    public static void main(String[] args) {
        maxSubArray2(new int[]{-1});
    }

}
