package uk.matvey.play.leet0117.java1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    private final LinkedList<Node> nodes = new LinkedList<>();
    private final List<LinkedList<Node>> levels = new ArrayList<>();

    public void connect(Node root) {
        nodes.offer(root);
        traverse();
        next(root, 0);
    }

    private void traverse() {
        if (nodes.isEmpty()) {
            return;
        }
        var level = new LinkedList<Node>();
        for (var i = nodes.size(); i > 0; i--) {
            var node = nodes.poll();
            if (node == null) {
                continue;
            }
            level.offer(node);
            nodes.offer(node.left);
            nodes.offer(node.right);
        }
        levels.add(level);
        traverse();
    }

    private void next(Node root, int levelIndex) {
        if (root == null) {
            return;
        }
        var level = levels.get(levelIndex);
        var node = level.poll();
        if (node == root) {
            node = level.poll();
        }
        root.next = node;
        next(root.left, levelIndex + 1);
        next(root.right, levelIndex + 1);
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
