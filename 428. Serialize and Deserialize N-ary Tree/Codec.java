import java.util.*;

import static java.util.stream.Collectors.*;

class Codec {

    public String serialize(Node root) {
        if (root == null) {
            return "";
        }
        return "(" + root.val + ")[" + root.children.stream().map(this::serialize).collect(joining(",")) + "]";
    }
	
    public Node deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        var i = data.indexOf('[');
        var node = new Node(Integer.parseInt(data.substring(1, i - 1)), new ArrayList<>());
        while (i < data.length() - 1) {
            int open = 1, j = i + 1 + data.substring(i + 1).indexOf('[') + 1;
            if (j - 1 == i) {
                break;
            }
            for (; open > 0; j++) {
                switch (data.charAt(j)) {
                    case '[': open++; break;
                    case ']': open--; break;
                }
            }
            node.children.add(deserialize(data.substring(i + 1, j)));
            i = j;
        }
        return node;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
