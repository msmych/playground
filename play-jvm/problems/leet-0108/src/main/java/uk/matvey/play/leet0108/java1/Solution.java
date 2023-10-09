package uk.matvey.play.leet0108.java1;

import uk.matvey.play.types.TreeNode;

import java.util.Arrays;

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
