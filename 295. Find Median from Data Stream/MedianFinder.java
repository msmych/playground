import java.util.List;
import java.util.ArrayList;

class MedianFinder {

    private final List<Integer> list = new ArrayList<>();

    /** initialize your data structure here. */
    public MedianFinder() {}
    
    public void addNum(int num) {
        if (list.isEmpty()) {
            list.add(num);
        } else {
            int left = 0, right = list.size() - 1;
            while (left < right - 1) {
                int mid = left + (right - left) / 2;
                int m = list.get(mid);
                if (mid != 0 && mid != list.size() - 1 && list.get(mid - 1) == m && m == list.get(mid + 1)) {
                    if (num < m) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                    continue;
                } else if (mid == 0 || num < list.get(mid - 1)) {
                    right = mid - 1;
                } else if (num < list.get(mid)) {
                    list.add(mid, num);
                    return;
                } else if (mid == list.size() - 1 || num < list.get(mid - 1)) {
                    list.add(mid + 1, num);
                    return;
                } else {
                    left = mid + 1;
                }
            }
            if (num < list.get(left)) {
                list.add(left, num);
            } else if (num < list.get(right)) {
                list.add(right, num);
            } else {
                list.add(right + 1, num);
            }
        }
    }
    
    public double findMedian() {
        return list.size() % 2 == 1 
            ? (double) list.get(list.size() / 2)
            : (((double) list.get(list.size() / 2 - 1)) + ((double) list.get(list.size() / 2))) / 2.0;
    }
    
    public static void main(String... args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(String.format(
            "Median: %s | Expected: %s", 
            finder.findMedian(), 1.5));
        finder.addNum(3);
        System.out.println(String.format(
            "Median: %s | Expected: %s", 
            finder.findMedian(), 2.0));
        finder.addNum(2);
        finder.addNum(2);
        finder.addNum(2);
        finder.addNum(3);
        finder.addNum(1);
    }
}

