import java.util.*;

import static java.lang.Math.*;
import static java.util.stream.IntStream.*;
import static java.util.stream.Collectors.*;

class Solution {

    private static class Rect {

        int x1, y1, x2, y2, i;

        Rect(int[] rect, int lastIndex) {
            x1 = rect[0];
            y1 = rect[1];
            x2 = rect[2];
            y2 = rect[3];
            i = lastIndex + (x2 - x1 + 1) * (y2 - y1 + 1);
        }
    }

    private final List<Rect> rects = new ArrayList<>();
    private final Random rand = new Random();

    public Solution(int[][] rects) {
        var i = 0;
        for (var rect : rects) {
            var r = new Rect(rect, i);
            this.rects.add(r);
            i = r.i;
        }
    }
    
    public int[] pick() {
        var i = abs(rand.nextInt(rects.get(rects.size() - 1).i));
        int left = 0, right = rects.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (i < rects.get(mid).i) {
                if (mid == rects.size() - 1 || i >= rects.get(mid + 1).i) {
                    return point(rects.get(mid));
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return point(rects.get(left));
    }

    private int[] point(Rect rect) {
        return new int[]{ 
            rect.x1 + rand.nextInt(rect.x2 - rect.x1 + 1), 
            rect.y1 + rand.nextInt(rect.y2 - rect.y1 + 1) 
        };
    }

    public static void main(String... args) {
        var s1 = new Solution(new int[][]{{ 1, 1, 5, 5 }});
        System.out.println(range(0, 1000)
            .mapToObj(i -> s1.pick())
            .map(Arrays::toString)
            .collect(groupingBy(p -> p, counting())));
        var s2 = new Solution(new int[][]{{ -2,-2,-1,-1 }, { 1,0,3,0 }});
        System.out.println(range(0, 1000)
            .mapToObj(i -> s2.pick())
            .map(Arrays::toString)
            .collect(groupingBy(p -> p, counting())));
    }

}
