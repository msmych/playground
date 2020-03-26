import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import static java.util.Collections.emptyList;

class Solution {
    public List<String> addOperators(String num, int target) {
        if (num.isEmpty() || Long.parseLong(num) > Integer.MAX_VALUE) {
            return emptyList();
        }
        return new ArrayList<>(next(num, target, '+', 0));
    }

    private Set<String> next(String num, int target, char operator, int lastItem) {
        Set<String> expressions = new HashSet<>();
        int n;
        switch (operator) {
            case '+':
                n = Integer.parseInt(num);
                if (n == target && (num.length() == 1 || !num.startsWith("0"))) {
                    expressions.add(num);
                }
                break;
            case '-':
                n = -Integer.parseInt(num);
                if (n == target && (num.length() == 1 || !num.startsWith("0"))) {
                    expressions.add(num);
                }
                break;
            case '*':
                n = Integer.parseInt(num);
                if (lastItem * n == target && (num.length() == 1 || !num.startsWith("0"))) {
                    expressions.add(num);
                }
        }
        for (int i = 1; i < num.length(); i++) {
            String leftNum = num.substring(0, i);
            if (leftNum.length() > 1 && leftNum.startsWith("0")) {
                continue;
            }
            int left = left(leftNum, operator, lastItem);
            String rightNum = num.substring(i);
            for (String s : next(rightNum, target - left, '+', 0)) {
                expressions.add(leftNum + "+" + s);
            }
            for (String s : next(rightNum, target - left, '-', 0)) {
                expressions.add(leftNum + "-" + s);
            }
            for (String s : next(rightNum, target, '*', left)) {
                expressions.add(leftNum + "*" + s);
            }
        }
        return expressions;
    }

    private int left(String s, char operator, int lastItem) {
        switch (operator) {
            case '+': return Integer.parseInt(s);
            case '-': return -Integer.parseInt(s);
            case '*': return lastItem * Integer.parseInt(s);
            default: throw new IllegalArgumentException();
        }
    }

    // java Solution.java "123" "6" "[1+2+3, 1*2*3]" "232" "8" "[2*3+2, 2+3*2]" "105" "5" "[1*0+5,10-5]" "00" "0" "[0+0,0-0,0*0]" "3456237490" "9191" "[]" "" 5 "[]" 000 0 "[0*0*0,0*0+0,0*0-0,0+0*0,0+0+0,0+0-0,0-0*0,0-0+0,0-0-0]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String num = args[i], target = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: num = %s, target = %s",
                new Solution().addOperators(num, Integer.parseInt(target)), expected, num, target));
        }
    }
}
