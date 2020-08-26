import java.util.*;

class Solution {

    public List<String> fizzBuzz(int n) {
        var list = new ArrayList<String>();
        for (var i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    // java Solution.java "15" "[1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().fizzBuzz(Integer.parseInt(n)), expected, n));
        }
    }
}
