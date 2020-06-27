import static java.util.Arrays.*;

class Solution {
    public double average(int[] salary) {
        return stream(salary)
            .sorted()
            .skip(1)
            .limit(salary.length - 2)
            .mapToDouble(i -> (double) i)
            .average()
            .getAsDouble();
    }

    // java Solution.java "[4000,3000,1000,2000]" "2500.00000" "[1000,2000,3000]" "2000.00000" "[6000,5000,4000,3000,2000,1000]" "3500.00000" "[8000,9000,2000,3000,6000,1000]" "4750.00000"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String salary = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: salary = %s",
                new Solution().average(array(salary)), expected, salary));
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
