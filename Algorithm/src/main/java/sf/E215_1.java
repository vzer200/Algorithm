package sf;

import java.util.concurrent.ThreadLocalRandom;

public class E215_1 {
    //数组中的第k大的元素
    //快速选择算法
    //在快速排序的基础上进行优化


    public void quick(int[] nums,int left, int right){
        if (left>right){
            return ;
        }
        int p = partition(nums, left, right);
        quick(nums,left,p);
        quick(nums,p+1,right);
    }

    private int partition(int[] nums, int left, int right) {
        int x = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(nums,x,left);
        int pv = nums[left];
        int i = left+1;
        int j = right;
        while(i<=j){
            while(i<=j&&nums[i]<pv){
                i++;
            }
            while (i<=j&&nums[j]>pv){
                j--;
            }
            if (i<=j){
                swap(nums,i,j);
                i++;
                j--;
            }
        }
        swap(nums,left,j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int s(int[] nums,int left, int right,int i){
        int p = partition(nums, left, right);
        if (p==i){
            return nums[p];
        }
        if (i<p){
            return s(nums,left,p-1,i);
        }else {
            return s(nums,p+1,right,i);
        }

    }
    public int findKthLargest(int[] nums, int k) {
        return s(nums,0,nums.length-1,nums.length-k);
    }

}
