import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int n : arr) {
            if (set.contains(2 * n) || n % 2 == 0 && set.contains(n / 2)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }

    // java Solution.java "[10,2,5,3]" "true" "[7,1,14,11]" "true" "[3,1,7,11]" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String arr = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: arr = %s",
                new Solution().checkIfExist(array(arr)), expected, arr));
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
