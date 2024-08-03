package sf;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class E217 {
    //重复元素
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Object> map = new HashMap<>();
        Object value = new Object();
        for (int num : nums) {

            Object put = map.put(num, value);
            if (put != null) {
                return true;
            }
        }
        return false;
    }
}
