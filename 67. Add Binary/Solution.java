import java.util.*;

class Solution {

    public String addBinary(String a, String b) {
        return boolsToString(add(toBoolArray(a), toBoolArray(b)));
    }
    
    private List<Boolean> toBoolArray(String s) {
        var bools = new ArrayList<Boolean>();
        for (var i = s.length() - 1; i >= 0; i--) {
            bools.add(s.charAt(i) == '1');
        }
        return bools;
    }

    private List<Boolean> add(List<Boolean> aBools, List<Boolean> bBools) {
        var sumBools = new ArrayList<Boolean>();
        var shift = false;
        for (var i = 0; i < aBools.size() || i < bBools.size() || shift; i++) {
            boolean a = i < aBools.size() ? aBools.get(i) : false, b = i < bBools.size() ? bBools.get(i) : false;
            var sum = a != b;
            if (shift) {
                sum = !sum;
            }
            sumBools.add(sum);
            shift = (a && b) || ((a || b) && shift);
        }
        return sumBools;
    }

    private String boolsToString(List<Boolean> bools) {
        var sb = new StringBuilder();
        for (var i = bools.size() - 1; i >= 0; i--) {
            sb.append(bools.get(i) ? '1' : '0');
        }
        return sb.toString();
    }

    // java Solution.java "11" "1" "100" "1010" "1011" "10101"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String a = args[i], b = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: a = %s, b = %s",
                new Solution().addBinary(a, b), expected, a, b));
        }
    }
}
