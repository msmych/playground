import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        var max = stream(candies).max().getAsInt();
        return stream(candies)
            .mapToObj(candy -> candy + extraCandies >= max)
            .collect(toList());
    }

    // java Solution.java "[2,3,5,1,3]" "3" "[true,true,true,false,true]" "[4,2,1,1,2]" "1" "[true,false,false,false,false]" "[12,1,12]" "10" "[true,false,true]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String candies = args[i], extraCandies = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: candies = %s, extraCandies = %s",
                new Solution().kidsWithCandies(array(candies), Integer.parseInt(extraCandies)), expected, candies, extraCandies));
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
