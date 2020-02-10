import static java.util.stream.IntStream.range;

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        double average = range(0, k)
            .mapToDouble(i -> (double) arr[i])
            .average()
            .getAsDouble();
        int num = 0;
        if (average >= threshold) {
            num++;
        }
        for (int i = k; i < arr.length; i++) {
            average += (double) (arr[i] - arr[i - k]) / (double) k;
            if (average >= threshold) {
                num++;
            }
        }
        return num;
    }

    // java Solution.java "[2,2,2,2,5,5,5,8]" "3" "4" "3" "[1,1,1,1,1]" "1" "0" "5" "[11,13,17,23,29,31,7,5,2,3]" "3" "5" "6" "[7,7,7,7,7,7,7]" "7" "7" "1" "[4,4,4,4]" "4" "1" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String arr = args[i], k = args[i + 1], threshold = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: arr = %s, k = %s, threshold = %s",
                new Solution().numOfSubarrays(array(arr), Integer.parseInt(k), Integer.parseInt(threshold)), expected, arr, k, threshold));
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
