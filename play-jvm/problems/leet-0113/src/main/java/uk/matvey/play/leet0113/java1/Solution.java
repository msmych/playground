package uk.matvey.play.leet0113.java1;

import uk.matvey.play.types.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        var paths = new ArrayList<List<Integer>>();
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                paths.add(List.of(root.val));
            }
            return paths;
        }
        for (var leftPath : pathSum(root.left, sum - root.val)) {
            var path = new ArrayList<>(leftPath);
            path.add(0, root.val);
            paths.add(path);
        }
        for (var rightPath : pathSum(root.right, sum - root.val)) {
            var path = new ArrayList<>(rightPath);
            path.add(0, root.val);
            paths.add(path);
        }
        return paths;
    }
}
