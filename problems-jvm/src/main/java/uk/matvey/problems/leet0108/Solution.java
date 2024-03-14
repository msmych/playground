package uk.matvey.problems.leet0108;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        var mid = nums.length / 2;
        var node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(Arrays.copyOf(nums, mid));
        node.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return node;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{-10, -3, 0, 5, 9};

        TreeNode result = new Solution().sortedArrayToBST(nums);

        assertThat(result).isEqualTo(TreeNode.treeNode(0, -3, 9, -10, null, 5));
    }
}
