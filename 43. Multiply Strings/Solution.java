class Solution {
    public String multiply(String num1, String num2) {
        if (num1.isEmpty() || num2.isEmpty()) {
            return "0";
        }
        var subProducts = new String[num2.length()];
        var reminder = 0;
        for (var i = num2.length() - 1; i >= 0; i--) {
            int i2 = num2.length() - i - 1, n2 = num2.charAt(i) - '0';
            subProducts[i2] = "";
            for (var shift = 0; shift < i2; shift++) {
                subProducts[i2] = subProducts[i2] + '0';
            }
            for (var j = num1.length() - 1; j >= 0; j--) {
                int n1 = num1.charAt(j) - '0', p = n1 * n2 + reminder;
                reminder = p / 10;
                subProducts[i2] = p % 10 + subProducts[i2];
            }
            if (reminder > 0) {
                subProducts[i2] = reminder + subProducts[i2];
                reminder = 0;
            }
            var extra = num2.length() + num1.length() - subProducts[i2].length();
            for (; extra > 0; extra--) {
                subProducts[i2] = '0' + subProducts[i2];
            }
        }
        var sb = new StringBuilder();
        reminder = 0;
        for (var i = subProducts[subProducts.length - 1].length() - 1; i >= 0; i--) {
            var sum = reminder;
            for (var subProduct : subProducts) {
                sum += subProduct.charAt(i) - '0';
            }
            reminder = sum / 10;
            sb.insert(0, sum % 10);
        }
        var product = sb.toString();
        while (product.length() > 1 && product.charAt(0) == '0') {
            product = product.substring(1);
        }
        return product;
    }

    // java Solution.java "2" "3" "6" "123" "456" "56088"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String num1 = args[i], num2 = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: num1 = %s, num2 = %s",
                new Solution().multiply(num1, num2), expected, num1, num2));
        }
    }
}
