package sf;

public class E153 {
    public int findMin(int[] nums) {
        //主要 要看出来哪部分是升序，哪部分是降序
        int start  = 0;
        int end = nums.length-1;

        while (start<=end){
            int mid = start+(end-start)/2;
            if (nums[mid]>nums[end]){
                start = mid+1;
            }else {
                end = mid-1;
            }


        }
        return nums[start];
    }

}
