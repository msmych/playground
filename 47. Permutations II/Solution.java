import java.util.*;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        var perms = new HashSet<List<Integer>>();
        var original = stream(nums).boxed().collect(toList());
        perms.add(original);
        List<Integer> perm;
        while (true) {
            perm = nextPermutation(nums);
            if (!perm.equals(original)) {
                perms.add(perm);
            } else {
                break;
            }
        }
        return new ArrayList<>(perms);
    }

    private List<Integer> nextPermutation(int[] nums) {
        int sourceIndex = -1, targetIndex = -1;
        for (var i = nums.length - 1; i > 0; i--) {
            var source = nums[i];
            for (var j = i - 1; j >= 0; j--) {
                var target = nums[j];
                if (source > target && (targetIndex == -1 || j > targetIndex)) {
                    sourceIndex = i;
                    targetIndex = j;
                }
            }
        }
        if (sourceIndex != -1) {
            var temp = nums[sourceIndex];
            nums[sourceIndex] = nums[targetIndex];
            nums[targetIndex] = temp;
            sort(nums, targetIndex + 1);
        } else {
            sort(nums, 0);
        }
        return stream(nums).boxed().collect(toList());
    }

    private void sort(int[] nums, int from) {
        for (var i = from; i < nums.length - 1; i++) {
            var minIndex = i;
            for (var j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            var temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }

    // java Solution.java "[1,1,2]" "[[1,1,2],[1,2,1],[2,1,1]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().permuteUnique(array(nums)), expected, nums));
        }
    }

    private static int[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
