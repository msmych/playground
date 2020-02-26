import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Queue<Integer> nodes = new LinkedList<>();
        nodes.offer(0);
        Set<Integer> visited = new HashSet<>();
        while (!nodes.isEmpty()) {
            Integer node = nodes.poll();
            if (visited.contains(node)) {
                return false;
            }
            visited.add(node);
            if (leftChild[node] != -1) {
                nodes.offer(leftChild[node]);
            }
            if (rightChild[node] != -1) {
                nodes.offer(rightChild[node]);
            }
        }
        return visited.size() == n;
    }

    // java Solution.java "4" "[1,-1,3,-1]" "[2,-1,-1,-1]" "true" "4" "[1,-1,3,-1]" "[2,3,-1,-1]" "false" "2" "[1,0]" "[-1,-1]" "false" "6" "[1,-1,-1,4,-1,-1]" "[2,-1,-1,5,-1,-1]" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String n = args[i], leftChild = args[i + 1], rightChild = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, leftChild = %s, rightChild = %s",
                new Solution().validateBinaryTreeNodes(Integer.parseInt(n), array(leftChild), array(rightChild)), expected, n, leftChild, rightChild));
        }
    }

    private static int[] array(String s) {
        String[] elements = s.substring(1, s.length() - 1).replaceAll(" ", "").split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
