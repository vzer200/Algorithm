package sf;

public class E283 {
    public static void moveZeroes(int[] nums) {

        int left = 0 ;
        int right = 0 ;
        //0 1 0 3 4 0 1
        //1 0 0 3 4 1 2
        //如果right为0 right+1
        //1 0 0 3 4  1 3
        //1 3 0 0 4  2  4
        while(right<nums.length){
            if (nums[right]!=0){
                swap(nums,left,right);//交换
                left++;

            }
            right++;
        }

    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }




    public static void moveZeroes1(int[] nums) {
        //将0移动到末尾
        int left  = 0;
        int right = 0;
        while (right<nums.length){
            //left用来记录0 right位置与left位置进行交换
            if (nums[right]!=0){
                swap(nums,left,right);
                left++;
            }
            right++;
        }

    }




}
