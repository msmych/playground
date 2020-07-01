import java.util.*;

class Solution {

    private final Map<Character, List<String>> keyboard = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        putButton('2', "a", "b", "c");
        putButton('3', "d", "e", "f");
        putButton('4', "g", "h", "i");
        putButton('5', "j", "k", "l");
        putButton('6', "m", "n", "o");
        putButton('7', "p", "q", "r", "s");
        putButton('8', "t", "u", "v");
        putButton('9', "w", "x", "y", "z");
        return getCombinations(digits);
    }

    private void putButton(char digit, String... letters) {
        var button = new ArrayList<String>();
        Collections.addAll(button, letters);
        keyboard.put(digit, button);
    }

    private List<String> getCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        if (digits.length() == 1) {
            return keyboard.get(digits.charAt(0));
        }
        var combinations = new ArrayList<String>();
        for (var next : getCombinations(digits.substring(1))) {
            for (var letter : keyboard.get(digits.charAt(0))) {
                combinations.add(letter + next);
            }
        }
        return combinations;
    }

    // java Solution.java "23" "[ad, ae, af, bd, be, bf, cd, ce, cf]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String digits = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: digits = %s",
                new Solution().letterCombinations(digits), expected, digits));
        }
    }
}
