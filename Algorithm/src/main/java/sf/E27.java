package sf;

public class E27 {
    public static int removeElement(int[] nums, int val) {
     //快慢指针
        int fast = 0;
        int slow = 0;
        while (fast<nums.length){
            if (nums[fast]!=val){
                 nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }


    public static void main(String[] args) {
        int[] a = {3, 2, 2, 3};
        int i = removeElement(a, 3);
        System.out.println(i);
    }
}
