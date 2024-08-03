package sf;

import java.util.Arrays;

public class E189 {
    public static void rotate(int[] nums, int k) {

        //向右动k个位置
        //翻转数组的方法
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k);
        reverse(nums,k,nums.length-1);


    }
    //翻转头 翻转尾
    public static void reverse(int[] num,int i,int j){
        //从索引i开始翻转 翻转到索引j
        while (i<j){
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
            i++;
            j--;
        }
    }


    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7};
        rotate(num, 3);
        for (int i : num) {
            System.out.println(i);
        }

    }


    public void rotate2(int[] nums, int k) {

        //给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
        //思路:
        k%=nums.length;
        reverse2(nums,0,nums.length-1);
        reverse2(nums,0,k-1);
        reverse2(nums,k,nums.length-1);

    }


    public void reverse2(int[] nums,int i, int j ){
        //翻转数组
        while (i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }

    }

}
