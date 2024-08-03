package sf;

import java.util.HashSet;

public class E219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> map = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.contains(nums[i])) {
                return true;
            } else {
                map.add(nums[i]);
            }

            if (map.size() > k) {
                map.remove(nums[i - k]);
            }

        }

        return false;
    }
}
