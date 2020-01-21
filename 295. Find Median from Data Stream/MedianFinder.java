import java.util.List;
import java.util.ArrayList;

import static java.util.Comparator.naturalOrder;

class MedianFinder {

    private final List<Integer> list = new ArrayList<>();

    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        list.add(num);
        list.sort(naturalOrder());
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
    }
}

