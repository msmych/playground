class Solution {

    public int[] productExceptSelf(int[] nums) {
        var products = new int[nums.length];
        products[0] = 1;
        for (var i = 1; i < products.length; i++) {
            products[i] = products[i - 1] * nums[i - 1];
        }
        var product = 1;
        for (var i = products.length - 2; i >= 0; i--) {
            products[i] *= nums[i + 1] * product;
            product *= nums[i + 1];
        }
        return products;
    }

    // java Solution.java "[1,2,3,4]" "[24,12,8,6]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                string(new Solution().productExceptSelf(intArr(nums))), expected, nums));
        }
    }

    private static int[] intArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
