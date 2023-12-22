package uk.matvey.play.leet1357.java1;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cashier {
    private final int n;
    private final int discount;
    private final Map<Integer, Integer> productPrices;

    private int k = 0;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        productPrices = IntStream.range(0, products.length)
                .boxed()
                .collect(Collectors.toMap(i -> products[i], i -> prices[i]));
    }

    public double getBill(int[] product, int[] amount) {
        k++;
        double sum = IntStream.range(0, product.length)
                .mapToDouble(i -> amount[i] * productPrices.get(product[i]))
                .sum();
        if (k % n == 0) {
            sum -= (discount * sum) / 100.0;
        }
        return sum;
    }
}
