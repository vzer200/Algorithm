package sf;

import java.util.HashSet;
import java.util.Set;

public class E41 {

    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <nums.length ; i++) {
            boolean contains = set.contains(i);
            if (!contains){
                return i;
            }
        }
        return nums.length+1;
    }
    //实际上，对于一个长度为 N 的数组，其中没有出现的最小正整数只能在 [1,N+1] 中。 我死也想不到这个结论


}
