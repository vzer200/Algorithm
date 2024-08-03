package sf;

public class E80 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 2;
        while (fast<nums.length){
            if (nums[fast]!=nums[slow]){
                nums[slow+2] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow+2;
    }
}
