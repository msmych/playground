import java.util.HashMap;

class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        var map = new HashMap<Character, Integer>();
        if (!croakOfFrogs.endsWith("k")) {
            return -1;
        }
        int frogs = 0, balance = 0;
        for (var c : croakOfFrogs.toCharArray()) {
            switch (c) {
                case 'c': 
                    if (balance == 0) {
                        frogs++;
                    } else {
                        balance--;
                    }
                    map.merge(c, 1, Integer::sum);
                    break;
                case 'r':
                    if (map.getOrDefault('c', 0) - map.getOrDefault('r', 0) < 1) {
                        return -1;
                    }
                    map.merge(c, 1, Integer::sum);
                    break;
                case 'o':
                    if (map.getOrDefault('r', 0) - map.getOrDefault('o', 0) < 1) {
                        return -1;
                    }
                    map.merge(c, 1, Integer::sum);
                    break;
                case 'a':
                    if (map.getOrDefault('o', 0) - map.getOrDefault('a', 0) < 1) {
                        return -1;
                    }
                    map.merge(c, 1, Integer::sum);
                    break;
                case 'k':
                    if (map.getOrDefault('a', 0) - map.getOrDefault('k', 0) < 1) {
                        return -1;
                    }
                    map.merge(c, 1, Integer::sum);
                    balance++;
            }
        }
        return frogs;
    }

    // java Solution.java "croakcroak" "1" "crcoakroak" "2" "croakcrook" "-1" "croakcroa" "-1" "aoocrrackk" -1 "crocakcroraoakk" 2
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String croakOfFrogs = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: croakOfFrogs = %s",
                new Solution().minNumberOfFrogs(croakOfFrogs), expected, croakOfFrogs));
        }
    }
}
