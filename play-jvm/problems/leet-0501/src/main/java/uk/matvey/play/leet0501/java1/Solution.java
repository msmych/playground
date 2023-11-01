package uk.matvey.play.leet0501.java1;

import uk.matvey.play.types.TreeNode;

import java.util.*;

public class Solution {
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> occurrences = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            occurrences.merge(node.val, 1, Integer::sum);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        int max = occurrences.values().stream().mapToInt(n -> n).max().orElse(0);
        List<Integer> modesList = occurrences.entrySet().stream()
            .filter(e -> e.getValue().equals(max))
            .map(Map.Entry::getKey)
            .toList();
        var modes = new int[modesList.size()];
        for (int i = 0; i < modesList.size(); i++) {
            modes[i] = modesList.get(i);
        }
        return modes;
    }
}
