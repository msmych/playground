import java.util.*;

class Solution {

    public int[] plusOne(int[] digits) {
        var list = getList(digits);
        increment(list);
        return getArray(list);
    }

    private List<Integer> getList(int[] digits) {
        var list = new ArrayList<Integer>();
        for (var digit : digits) {
            list.add(digit);
        }
        return list;
    }

    private void increment(List<Integer> list) {
        boolean shift;
        int i = list.size() - 1;
        do {
            var digit = list.get(i) + 1;
            shift = digit == 10;
            list.set(i, digit % 10);
        } while (--i >= 0 && shift);
        if (shift) {
            list.add(0, 1);
        }
    }

    private int[] getArray(List<Integer> digits) {
        var array = new int[digits.size()];
        for (var i = 0; i < array.length; i++) {
            array[i] = digits.get(i);
        }
        return array;
    }

    // java Solution.java "[1,2,3]" "[1,2,4]" "[4,3,2,1]" "[4,3,2,2]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String digits = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: digits = %s",
                string(new Solution().plusOne(intArr(digits))), expected, digits));
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

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
