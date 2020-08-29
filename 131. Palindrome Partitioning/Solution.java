import java.util.*;

class Solution {

    private final Map<String, Boolean> cache = new HashMap<>();

    public List<List<String>> partition(String s) {
        if (s.isEmpty()) {
            return new ArrayList<>();
        }
        var partitions = new ArrayList<List<String>>();
        if (isPalindrome(s)) {
            partitions.add(List.of(s));
        }
        for (var i = 1; i < s.length(); i++) {
            var left = s.substring(0, i);
            if (isPalindrome(left)) {
                for (var nextPartition : partition(s.substring(i))) {
                    var partition = new ArrayList<>(nextPartition);
                    partition.add(0, left);
                    partitions.add(partition);
                }
            }
        }
        return partitions;
    }

    private boolean isPalindrome(String s) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        var isPalindrome = new StringBuffer(s).reverse().toString().equals(s);
        cache.put(s, isPalindrome);
        return isPalindrome;
    }

    // java Solution.java "aab" "[[aa,b],[a,a,b]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().partition(s), expected, s));
        }
    }
}
