import java.util.List;
import java.util.ArrayList;

import static java.util.Comparator.comparingInt;

class SummaryRanges {

    private final List<List<Integer>> ranges = new ArrayList<>();

    private boolean sorted = true;

    public SummaryRanges() {}
    
    public void addNum(int val) {
        if (ranges.stream().anyMatch(range -> val >= range.get(0) && val <= range.get(1))) {
            return;
        }
        var left = ranges.stream().filter(range -> range.get(1) == val - 1).findAny();
        var right = ranges.stream().filter(range -> range.get(0) == val + 1).findAny();
        if (left.isEmpty() && right.isEmpty()) {
            ranges.add(List.of(val, val));
        } else if (left.isPresent() && right.isPresent()) {
            ranges.remove(left.get());
            ranges.remove(right.get());
            ranges.add(List.of(left.get().get(0), right.get().get(1)));
        } else if (left.isPresent()) {
            ranges.remove(left.get());
            ranges.add(List.of(left.get().get(0), val));
        } else {
            ranges.remove(right.get());
            ranges.add(List.of(val, right.get().get(1)));
        }
        sorted = false;
    }
    
    public int[][] getIntervals() {
        if (!sorted) {
            ranges.sort(comparingInt(range -> range.get(0)));
            sorted = true;
        }
        var intervals = new int[ranges.size()][2];
        for (var i = 0; i < ranges.size(); i++) {
            intervals[i] = new int[]{ranges.get(i).get(0), ranges.get(i).get(1)};
        }
        return intervals;
    }

    public static void main(String... args) {
        var ranges = new SummaryRanges();
        ranges.addNum(1);
        System.out.println(String.format("Output: %s | Expected: %s", string(ranges.getIntervals()), "[1, 1]"));
        ranges.addNum(3);
        System.out.println(String.format("Output: %s | Expected: %s", string(ranges.getIntervals()), "[1, 1], [3, 3]"));
        ranges.addNum(7);
        System.out.println(String.format("Output: %s | Expected: %s", string(ranges.getIntervals()), "[1, 1], [3, 3], [7, 7]"));
        ranges.addNum(2);
        System.out.println(String.format("Output: %s | Expected: %s", string(ranges.getIntervals()), "[1, 1], [7, 7]"));
        ranges.addNum(6);
        System.out.println(String.format("Output: %s | Expected: %s", string(ranges.getIntervals()), "[1, 3], [6, 7]"));
    }

    private static String string(int[][] arr) {
        String s = "";
        for (int[] row : arr) {
            String r = "";
            for (int n : row) r += "," + n;
            if (row.length > 0) r = r.substring(1);
            s += ",[" + r + "]";
        }
        if (arr.length > 0) s = s.substring(1);
        return "[" + s + "]";
    }

}
