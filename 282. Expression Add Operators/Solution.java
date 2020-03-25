import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        return null;
    }

    // java Solution.java "123" "6" "[1+2+3, 1*2*3]" "232" "8" "[2*3+2, 2+3*2]" "105" "5" "[1*0+5,10-5]" "00" "0" "[0+0,0-0,0*0]" "3456237490" "9191" "[]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String num = args[i], target = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: num = %s, target = %s",
                new Solution().addOperators(num, Integer.parseInt(target)), expected, num, target));
        }
    }
}
