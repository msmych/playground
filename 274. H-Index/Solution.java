import static java.lang.Math.min;
import static java.util.Arrays.stream;
import static java.util.Comparator.reverseOrder;

class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        citations = stream(citations).boxed().sorted(reverseOrder()).mapToInt(n -> n).toArray();
        for (int i = citations.length - 1; i >= 0; i--) {
            if (i <= citations[i]) {
                return min(citations[i], i + 1);
            }
        }
        throw new IllegalArgumentException();
    }

    // java Solution.java "[3,0,6,1,5]" "3" "[1,2,3,3,4,5]" 3 "[]" 0 "[100]" 1 "[1,2,2,2,2,2,4,5]" 2
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String citations = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: citations = %s",
                new Solution().hIndex(array(citations)), expected, citations));
        }
    }

    private static int[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
