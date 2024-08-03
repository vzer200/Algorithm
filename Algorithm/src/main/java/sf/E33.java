package sf;

public class E33 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }


        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {

            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] <= nums[mid]) {



                    if (nums[start] <= target && target < nums[mid]) {
                        //在前半段找
                        end = mid - 1;
                    } else {
                        //在后半段找
                        start = mid + 1;
                    }


            } else {


                    if (target <= nums[end] && target > nums[mid]) {
                        //在后半段找
                        start = mid + 1;
                    } else {
                        //在前半段找
                        end = mid - 1;
                    }



            }


        }

        return -1;
    }
}
