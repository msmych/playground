import java.util.*;

class StockSpanner {

    private final Stack<Integer> prices = new Stack<>();
    private final Stack<Integer> spans = new Stack<>();

    public StockSpanner() {}
    
    public int next(int price) {
        var span = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            span += spans.pop();
        }
        prices.push(price);
        spans.push(span);
        return span;
    }

    public static void main(String... args) {
        var spanner = new StockSpanner();
        System.out.println(String.format("Output: %s | Expected: %s", spanner.next(100), 1));
        System.out.println(String.format("Output: %s | Expected: %s", spanner.next(80), 1));
        System.out.println(String.format("Output: %s | Expected: %s", spanner.next(60), 1));
        System.out.println(String.format("Output: %s | Expected: %s", spanner.next(70), 2));
        System.out.println(String.format("Output: %s | Expected: %s", spanner.next(60), 1));
        System.out.println(String.format("Output: %s | Expected: %s", spanner.next(75), 4));
        System.out.println(String.format("Output: %s | Expected: %s", spanner.next(85), 6));
    }
}
