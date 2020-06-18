import static java.util.Arrays.*;

class Solution {

    private int[] bloomDay;
    private int m, k;

    public int minDays(int[] bloomDay, int m, int k) {
        this.bloomDay = bloomDay;
        this.m = m;
        this.k = k;
        int left = 0, right = stream(bloomDay).max().getAsInt();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMakeBouquets(mid)) {
                if (mid == 0 || !canMakeBouquets(mid - 1)) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return canMakeBouquets(left) ? left : -1;
    }

    private boolean canMakeBouquets(int day) {
        var bouquets = 0;
        var flowers = 0;
        for (var bloom : bloomDay) {
            if (day >= bloom) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                    if (bouquets == m) {
                        return true;
                    }
                }
            } else {
                flowers = 0;
            }
        }
        return false;
    }

    // java Solution.java "[1,10,3,10,2]" "3" "1" "3" "[1,10,3,10,2]" "3" "2" "-1" "[7,7,7,7,12,7,7]" "2" "3" "12" "[1000000000,1000000000]" "1" "1" "1000000000" "[1,10,2,9,3,8,4,7,5,6]" "4" "2" "9"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String bloomDay = args[i], m = args[i + 1], k = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: bloomDay = %s, m = %s, k = %s",
                new Solution().minDays(array(bloomDay), Integer.parseInt(m), Integer.parseInt(k)), expected, bloomDay, m, k));
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
