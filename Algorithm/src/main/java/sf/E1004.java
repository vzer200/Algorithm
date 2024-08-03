package sf;

public class E1004 {

    public static int longestOnes(int[] nums, int k) {
        if (k >= nums.length) {
            return nums.length;
        }
        int left = 0;
        int max = 0;
        for (int right = 0; right < nums.length; right++) {
            while (k < 0) {

                if (nums[left] == 0) {
                    k++;

                }
                left++;
            }
            if (nums[right] != 1) {
                k--;
            }

            max = Math.max(right - left, max);
        }

        return max;
    }

    public static void main(String[] args) {
            int[] a = {1,1,1,0,0,0,1,1,1,1};
            longestOnes(a,0);
    }

}
