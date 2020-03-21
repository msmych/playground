import static java.lang.Math.min;

class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        int left = 0, right = citations.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int i = citations.length - mid - 1;
            if (i <= citations[mid]) {
                if (i == citations.length - 1 || i + 1 > citations[mid - 1]) {
                    return min(citations[mid], i + 1);
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        int i = citations.length - left - 1;
        return min(citations[left], i + 1);
    }

    // java Solution.java "[0,1,3,5,6]" "3" "[1,2,3,3,4,5]" 3 "[100]" 1 "[1,2,2,2,2,2,4,5]" 2 "[2,2,2]" 2
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
