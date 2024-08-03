package sf;

public class E238 {
    public static int[] productExceptSelf(int[] nums) {
        //除自身以外数组的乘积
        //题目标注了不准使用除法 不然我们可以用所有元素的和除以当前元素 就得到了anser
        //不准用除法之后 我们将要求的元素分割 分割成他左边的元素乘积和他右边的元素乘积 然后相乘得到anser

        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        L[0] = 1;
        R[nums.length - 1] = 1;
        for (int i = 1; i < L.length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        for (int i = R.length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            int anser = L[i] * R[i];
            nums[i] = anser;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ints = productExceptSelf(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }


    public int[] productExceptSelf2(int[] nums) {
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        L[0] = 1;
        R[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i - 1] * nums[i-1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = L[i] * R[i];
        }

        return nums;
    }


}
