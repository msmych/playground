import static java.util.stream.IntStream.*;

class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        return (int) range(0, startTime.length)
            .filter(i -> startTime[i] <= queryTime)
            .filter(i -> endTime[i] >= queryTime)
            .count();
    }

    // java Solution.java "[1,2,3]" "[3,2,7]" "4" "1" "[4]" "[4]" "4" "1" "[4]" "[4]" "5" "0" "[1,1,1,1]" "[1,3,2,4]" "7" "0" "[9,8,7,6,5,4,3,2,1]" "[10,10,10,10,10,10,10,10,10]" "5" "5"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String startTime = args[i], endTime = args[i + 1], queryTime = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: startTime = %s, endTime = %s, queryTime = %s",
                new Solution().busyStudent(array(startTime), array(endTime), Integer.parseInt(queryTime)), expected, startTime, endTime, queryTime));
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
