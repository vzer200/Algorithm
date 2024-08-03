package sf;

public class E45 {
    public static int jump(int[] nums) {
       int pos = nums.length-1;
       int count = 0;
       while (pos!=0){
           for (int i = 0; i < pos; i++) {
               if (nums[i]+i>pos){
                   pos = i;
                   count++;
                   break;
               }
           }
       }
       return count;
    }

    public static void main(String[] args) {
        int[] s = {2, 3, 1, 1, 4};
        jump(s);
    }
}
