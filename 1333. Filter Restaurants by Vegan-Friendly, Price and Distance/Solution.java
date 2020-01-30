import java.util.List;

import static java.lang.Integer.compare;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return stream(restaurants)
            .filter(restaurant -> veganFriendly == 0 || restaurant[2] == 1)
            .filter(restaurant -> restaurant[3] <= maxPrice)
            .filter(restaurant -> restaurant[4] <= maxDistance)
            .sorted((a, b) -> a[1] == b[1] ? compare(b[0], a[0]) : compare(b[1], a[1]))
            .map(restaurant -> restaurant[0])
            .collect(toList());
    }

    // java Solution.java "[[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]]" "1" "50" "10" "[3,1,5]" "[[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]]" "0" "50" "10" "[4,3,2,1,5]" "[[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]]" "0" "30" "3" "[4,5]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 5) {
            String restaurants = args[i], veganFriendly = args[i + 1], maxPrice = args[i + 2], maxDistance = args[i + 3], expected = args[i + 4];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: restaurants = %s, veganFriendly = %s, maxPrice = %s, maxDistance = %s",
                new Solution().filterRestaurants(array(restaurants), Integer.parseInt(veganFriendly), Integer.parseInt(maxPrice), Integer.parseInt(maxDistance)), expected, restaurants, veganFriendly, maxPrice, maxDistance));
        }
    }

    private static int[][] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0][0];
        String[] rows = s.substring(1, s.length() - 1).split("\\],\\[");
        if (rows[0].isEmpty()) return new int[0][0];
        int[][] arr = new int[rows.length][rows[0].split(",").length];
        for (int i = 0; i < arr.length; i++) {
            String[] elements = rows[i].split(",");
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = Integer.parseInt(elements[j]);
        }
        return arr;
    }
}
