package sf;

public class E75 {
    public void sortColors(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                swap(nums,i,index++);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                swap(nums,i,index++);
            }

        }

    }


    public void swap (int[] nums ,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
