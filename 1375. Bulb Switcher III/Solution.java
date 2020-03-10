import java.util.Set;
import java.util.HashSet;

import static java.util.stream.IntStream.range;

class Solution {
    public int numTimesAllBlue(int[] light) {
        int num = light[0] == 1 ? 1 : 0;
        Set<Integer> bulbs = new HashSet<>();
        bulbs.add(light[0]);
        int max = light[0];
        for (int i = 1; i < light.length; i++) {
            bulbs.add(light[i]);
            if (light[i] > max) {
                max = light[i];
            }
            if (range(1, max).allMatch(bulbs::contains)) {
                num++;
            }
        }
        return num;
    }

    // java Solution.java "[2,1,3,5,4]" "3" "[3,2,4,1,5]" "2" "[4,1,2,3]" "1" "[2,1,4,3,6,5]" "3" "[1,2,3,4,5,6]" "6"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String light = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: light = %s",
                new Solution().numTimesAllBlue(array(light)), expected, light));
        }
    }

    private static int[] array(String s) {
        String[] elements = s.substring(1, s.length() - 1).replaceAll(" ", "").split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
