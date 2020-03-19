import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

import static java.lang.Math.max;

class Solution {

    private static final Map<Integer, String> nums = new HashMap<>();
    
    static {
        nums.put(1, "One");
        nums.put(2, "Two");
        nums.put(3, "Three");
        nums.put(4, "Four");
        nums.put(5, "Five");
        nums.put(6, "Six");
        nums.put(7, "Seven");
        nums.put(8, "Eight");
        nums.put(9, "Nine");
        nums.put(10, "Ten");
        nums.put(11, "Eleven");
        nums.put(12, "Twelve");
        nums.put(13, "Thirteen");
        nums.put(14, "Fourteen");
        nums.put(15, "Fifteen");
        nums.put(16, "Sixteen");
        nums.put(17, "Seventeen");
        nums.put(18, "Eighteen");
        nums.put(19, "Nineteen");
        nums.put(20, "Twenty");
        nums.put(30, "Thirty");
        nums.put(40, "Forty");
        nums.put(50, "Fifty");
        nums.put(60, "Sixty");
        nums.put(70, "Seventy");
        nums.put(80, "Eighty");
        nums.put(90, "Ninety");
    }

    private final Queue<String> milleNames = new LinkedList<>(
        List.of("", "Thousand", "Million", "Billion"));

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String numString = String.valueOf(num);
        String s = "";
        for (int i = numString.length(); i > 0; i -= 3) {
            if (!s.isEmpty() && !s.startsWith(" ")) {
                s = " " + s;
            }
            String milleName = milleNames.poll();
            if (!milleName.isEmpty()) {
                milleName = " " + milleName;
            }
            String part = spell(Integer.parseInt(numString.substring(max(i - 3, 0), i)));
            if (!part.isEmpty()) {
                s = part + milleName + s;
            }
        }
        return s;
    }

    private String spell(int n) {
        if (nums.containsKey(n)) {
            return nums.get(n);
        }
        String s = "";
        if (n >= 100) {
            s += nums.get(n / 100) + " Hundred";
        }
        if (nums.containsKey(n % 100)) {
            if (!s.isEmpty()) {
                s += " ";
            }
            s += nums.get(n % 100);
        } else {
            if (n % 100 > 20) {
                if (!s.isEmpty()) {
                    s += " ";
                }
                s += nums.get(n % 100 / 10 * 10);
            }
            if (n % 10 > 0) {
                if (!s.isEmpty()) {
                    s += " ";
                }
                s += nums.get(n % 10);
            }
        }
        return s;
    }

    // java Solution.java "123" "One Hundred Twenty Three" "12345" "Twelve Thousand Three Hundred Forty Five" "1234567" "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven" "1234567891" "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One" 1000000 "One Million" 1000010 "One Million Ten"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String num = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: num = %s",
                new Solution().numberToWords(Integer.parseInt(num)), expected, num));
        }
    }
}
