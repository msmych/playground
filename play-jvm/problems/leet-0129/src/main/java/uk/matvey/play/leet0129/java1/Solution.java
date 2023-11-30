package uk.matvey.play.leet0129.java1;

import uk.matvey.play.types.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int sumNumbers(TreeNode root) {
        return nextNumbers(root).stream().mapToInt(this::toNumber).sum();
    }

    private List<List<Integer>> nextNumbers(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }
        var numbers = new ArrayList<List<Integer>>();
        if (node.left == null && node.right == null) {
            return List.of(List.of(node.val));
        }
        for (var num : nextNumbers(node.left)) {
            var next = new ArrayList<Integer>(num);
            next.add(node.val);
            numbers.add(next);
        }
        for (var num : nextNumbers(node.right)) {
            var next = new ArrayList<Integer>(num);
            next.add(node.val);
            numbers.add(next);
        }
        return numbers;
    }

    private int toNumber(List<Integer> list) {
        var num = 0;
        for (var i = list.size() - 1; i >= 0; i--) {
            num *= 10;
            num += list.get(i);
        }
        return num;
    }
}
