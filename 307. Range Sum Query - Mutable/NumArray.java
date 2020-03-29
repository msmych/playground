import java.util.Map;
import java.util.HashMap;

class NumArray {

    private final Map<Integer, Integer> sums = new HashMap<>();
    private final int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        sums.put(-1, 0);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums.put(i, sum);
        }
    }
    
    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        for (; i < sums.size() - 1; i++) {
            sums.merge(i, diff, Integer::sum);
        }
    }
    
    public int sumRange(int i, int j) {
        return sums.get(j) - sums.get(i - 1);
    }

    public static void main(String... args) {
        var arr = new NumArray(new int[]{1, 3, 5});
        System.out.println(String.format("Output: %s | Expected: %s", arr.sumRange(0, 2), 9));
        arr.update(1, 2);
        System.out.println(String.format("Output: %s | Expected: %s", arr.sumRange(0, 2), 8));
    }
}
