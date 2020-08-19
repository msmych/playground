import java.util.*;
import java.util.stream.*;

import static java.util.stream.IntStream.*;
import static java.util.stream.Collectors.*;

class Solution {

    private int k;

    public int[] numsSameConsecDiff(int N, int K) {
        this.k = K;
        return next(N, OptionalInt.empty()).stream()
            .distinct()
            .filter(num -> num.size() == 1 || num.get(0) != 0)
            .mapToInt(this::toInt)
            .toArray();
    }

    private List<List<Integer>> next(int n, OptionalInt lastDigit) {
        if (n < 1) {
            return List.of();
        }
        if (n == 1) {
            if (lastDigit.isEmpty()) {
                return rangeClosed(0, 9).mapToObj(i -> List.of(i)).collect(toList());
            } else {
                var last = lastDigit.getAsInt();
                if (last - k >= 0 && last + k <= 9) {
                    return List.of(List.of(last - k), List.of(last + k));
                } else if (last - k >= 0) {
                    return List.of(List.of(last - k));
                } else if (last + k <= 9) {
                    return List.of(List.of(last + k));
                } else {
                    return List.of();
                }
            }
        }
        var nums = new ArrayList<List<Integer>>();
        if (lastDigit.isEmpty()) {
            for (var i = 0; i <= 9; i++) {
                for (var next : next(n - 1, OptionalInt.of(i))) {
                    nums.add(Stream.concat(Stream.of(i), next.stream()).collect(toList()));
                }
            }
        } else {
            var last = lastDigit.getAsInt();
            if (last - k >= 0) {
                for (var next : next(n - 1, OptionalInt.of(last - k))) {
                    nums.add(Stream.concat(Stream.of(last - k), next.stream()).collect(toList()));
                }
            }
            if (last + k <= 9) {
                for (var next : next(n - 1, OptionalInt.of(last + k))) {
                    nums.add(Stream.concat(Stream.of(last + k), next.stream()).collect(toList()));
                }
            }
        }
        return nums;
    }

    private int toInt(List<Integer> num) {
        var n = 0;
        for (int i = num.size() - 1, d = 1; i >= 0; i--, d *= 10) {
            n += num.get(i) * d;
        }
        return n;
    }

    // java Solution.java "3" "7" "[181,292,707,818,929]" "2" "1" "[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]" 1 0 "[0,1,2,3,4,5,6,7,8,9]" 2 0 "[11,22,33,44,55,66,77,88,99]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String N = args[i], K = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: N = %s, K = %s",
                string(new Solution().numsSameConsecDiff(Integer.parseInt(N), Integer.parseInt(K))), expected, N, K));
        }
    }

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
