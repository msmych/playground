import static java.lang.Math.*;
import static java.util.stream.IntStream.*;

class MovingAverage {

    private final int[] queue;

    private int i = 0;

    public MovingAverage(int size) {
        queue = new int[size];
    }
    
    public double next(int val) {
        queue[i++ % queue.length] = val;
        return range(0, min(i, queue.length)).mapToDouble(n -> queue[n]).average().getAsDouble();
    }

    public static void main(String... args) {
        var movingAverage = new MovingAverage(3);
        System.out.println(String.format("Output: %s | Expected: %s | next = %s", movingAverage.next(1), 1, 1));
        System.out.println(String.format("Output: %s | Expected: %s | next = %s", movingAverage.next(10), 5.5, 10));
        System.out.println(String.format("Output: %s | Expected: %s | next = %s", movingAverage.next(3), 4.6, 3));
        System.out.println(String.format("Output: %s | Expected: %s | next = %s", movingAverage.next(5), 6, 5));
    }
}
