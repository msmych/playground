import static java.lang.Math.*;

class Solution {

    private static class Node {

        int val;
        int index;
        Node left;
        Node right;

        Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    private int k;
    private int t;
    private Node root;

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        this.k = k;
        this.t = t;
        for (var i = 0; i < nums.length; i++) {
            if (containsDuplicate(root, nums[i], i)) {
                return true;
            }
            root = addNode(root, nums[i], i);
        }
        return false;
    }

    private Node addNode(Node node, int val, int index) {
        if (node == null) {
            return new Node(val, index);
        } else if (val < node.val) {
            node.left = addNode(node.left, val, index);
        } else if (val > node.val) {
            node.right = addNode(node.right, val, index);
        }
        return node;
    }

    private boolean containsDuplicate(Node node, int val, int index) {
        if (node == null) {
            return false;
        }
        long valDistance = abs((long) val - node.val);
        if (valDistance <= t) {
            if (abs(index - node.index) <= k) {
                return true;
            }
            return containsDuplicate(node.left, val, index) || containsDuplicate(node.right, val, index);
        }
        return val < node.val ? containsDuplicate(node.left, val, index) : containsDuplicate(node.right, val, index);
    }

    // java Solution.java "[1,2,3,1]" "3" "0" "true" "[1,0,1,1]" "1" "2" "true" "[1,5,9,1,5,9]" "2" "3" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String nums = args[i], k = args[i + 1], t = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, k = %s, t = %s",
                new Solution().containsNearbyAlmostDuplicate(intArr(nums), Integer.parseInt(k), Integer.parseInt(t)), expected, nums, k, t));
        }
    }

    private static int[] intArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
