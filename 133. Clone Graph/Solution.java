import java.util.*;

class Solution {

    private final Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        var next = new Node(node.val, new ArrayList<>());
        map.put(next.val, next);
        for (var neighbor : node.neighbors) {
            next.neighbors.add(cloneGraph(neighbor));
        }
        return next;
    }

}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
