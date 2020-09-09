import java.util.*;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

class Solution {

    private static class Trie {
        Map<Character, Trie> children = new HashMap<>();
    }

    public int findMaximumXOR(int[] nums) {
        var bitmask = 1 << Integer.toBinaryString(stream(nums).max().getAsInt()).length();
        var strNums = stream(nums).map(num -> bitmask | num).mapToObj(Integer::toBinaryString).map(s -> s.substring(1)).collect(toList());
        var trie = new Trie();
        var max = 0;
        for (var s : strNums) {
            Trie node = trie, xorNode = trie;
            var xor = 0;
            for (var c : s.toCharArray()) {
                node.children.putIfAbsent(c, new Trie());
                node = node.children.get(c);
                var b = c == '1' ? '0' : '1';
                if (xorNode.children.containsKey(b)) {
                    xor = (xor << 1) | 1;
                    xorNode = xorNode.children.get(b);
                } else {
                    xor <<= 1;
                    xorNode = xorNode.children.get(c);
                }
            }
            if (xor > max) {
                max = xor;
            }
        }
        return max;
    }

    // java Solution.java "[3, 10, 5, 25, 2, 8]" "28"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().findMaximumXOR(intArr(nums)), expected, nums));
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
