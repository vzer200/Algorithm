package sf;

public class E724 {
    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] s1 = new int[n + 2], s2 = new int[n + 2];
        for (int i = 1; i <= n; i++) s1[i] = s1[i - 1] + nums[i - 1];
        for (int i = n; i >= 1; i--) s2[i] = s2[i + 1] + nums[i - 1];
        for (int i = 1; i <= n; i++) {
            if (s1[i] == s2[i]) return i - 1;
        }
        return -1;

    }

    public static int pivotIndex2(int[] nums) {
        int[] s = new int[nums.length+1];
        int[] l = new int[nums.length+1];
        l[0] = 0;
        s[0] = 0;
        for(int i =1; i<=nums.length;i++){
            s[i] = s[i-1] + nums[i-1];
            l[i] = l[i-1] + nums[nums.length-i];
        }
        for(int i = 1;i<=nums.length;i++){
            if(s[i]==l[i]){
                return i;
            }
        }



        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 7, 3, 6, 5, 6};
        pivotIndex(nums);

    }



}
