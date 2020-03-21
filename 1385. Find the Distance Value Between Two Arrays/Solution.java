import static java.lang.Math.abs;
import static java.util.Arrays.stream;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        return (int) stream(arr1)
            .filter(a -> stream(arr2)
                .allMatch(b -> abs(b - a) > d))
            .count();
    }

    // java Solution.java "[4,5,8]" "[10,9,1,8]" "2" "2" "[1,4,2,3]" "[-4,-3,6,10,20,30]" "3" "2" "[2,1,100,3]" "[-5,-2,10,-3,7]" "6" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String arr1 = args[i], arr2 = args[i + 1], d = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: arr1 = %s, arr2 = %s, d = %s",
                new Solution().findTheDistanceValue(array(arr1), array(arr2), Integer.parseInt(d)), expected, arr1, arr2, d));
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
