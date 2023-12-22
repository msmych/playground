package uk.matvey.play.leet1352.java1;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {
    private final List<Integer> products = new ArrayList<>();

    public ProductOfNumbers() {}

    public void add(int num) {
        if (num == 1) {
            products.add(num);
            return;
        }
        for (int i = 0; i < products.size(); i++) {
            products.set(i, products.get(i) * num);
        }
        products.add(num);
    }

    public int getProduct(int k) {
        return products.get(products.size() - k);
    }
}
