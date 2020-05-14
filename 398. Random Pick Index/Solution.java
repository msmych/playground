import java.util.*;

import static java.lang.Math.*;

class Solution {
    
    private final Map<Integer, List<Integer>> nums = new HashMap<>();

    public Solution(int[] nums) {
        for (var i = 0; i < nums.length; i++) {
            this.nums.putIfAbsent(nums[i], new ArrayList<>());
            this.nums.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        var indexes = nums.get(target);
        return indexes.get(abs(ThreadLocalRandom.current().nextInt(indexes.size())));
    }

}
