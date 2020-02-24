import java.util.Map;
import java.util.HashMap;

import static java.util.stream.IntStream.range;
import static java.util.stream.Collectors.toMap;

class Cashier {

    private final int n;
    private final int discount;
    private final Map<Integer, Integer> productPrices;

    private int k = 0;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        productPrices = range(0, products.length)
            .boxed()
            .collect(toMap(i -> products[i], i -> prices[i]));
    }

    public double getBill(int[] product, int[] amount) {
        k++;
        double sum = range(0, product.length)
            .mapToDouble(i -> amount[i] * productPrices.get(product[i]))
            .sum();
        if (k % n == 0) {
            sum -= (discount * sum) / 100.0;
        }
        return sum;
    }

    public static void main(String... args) {
        Cashier cashier = new Cashier(3, 50, new int[]{1,2,3,4,5,6,7}, new int[]{100,200,300,400,300,200,100});
        System.out.println(String.format("Output: %s | Expected: %s", cashier.getBill(new int[]{1,2}, new int[]{1,2}), 500.0));
        System.out.println(String.format("Output: %s | Expected: %s", cashier.getBill(new int[]{3,7}, new int[]{10,10}), 4000.0));
        System.out.println(String.format("Output: %s | Expected: %s", cashier.getBill(new int[]{1,2,3,4,5,6,7}, new int[]{1,1,1,1,1,1,1}), 800.0));
        System.out.println(String.format("Output: %s | Expected: %s", cashier.getBill(new int[]{4}, new int[]{10}), 4000.0));
        System.out.println(String.format("Output: %s | Expected: %s", cashier.getBill(new int[]{7,3}, new int[]{10,10}), 4000.0));
        System.out.println(String.format("Output: %s | Expected: %s", cashier.getBill(new int[]{7,5,3,1,6,4,2}, new int[]{10,10,10,9,9,9,7}), 7350.0));
        System.out.println(String.format("Output: %s | Expected: %s", cashier.getBill(new int[]{2,3,5}, new int[]{5,3,2}), 2500.0));
    }
}
