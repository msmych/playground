import java.util.List;
import java.util.ArrayList;

class ProductOfNumbers {

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

    public static void main(String... args) {
        ProductOfNumbers pon = new ProductOfNumbers();
        pon.add(3);
        pon.add(0);
        pon.add(2);
        pon.add(5);
        pon.add(4);
        System.out.println(String.format("Output: %s | Expected: %s", pon.getProduct(2), 20));
        System.out.println(String.format("Output: %s | Expected: %s", pon.getProduct(3), 40));
        System.out.println(String.format("Output: %s | Expected: %s", pon.getProduct(4), 0));
        pon.add(8);
        System.out.println(String.format("Output: %s | Expected: %s", pon.getProduct(2), 32));
    }
}
