class Solution {

    private int[] numbers;
    private int target;
    
    public int[] twoSum(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        if (numbers.length < 2) {
            throw new IllegalArgumentException();
        }
        for (var i = 0; i < numbers.length - 1; i++) {
            var j = findSecondIndex(i);
            if (j != -1) {
                return new int[]{i + 1, j + 1};
            }
        }
        throw new IllegalArgumentException();
    }
    
    private int findSecondIndex(int i) {
        int left = i + 1, right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = numbers[i] + numbers[mid];
            if (sum == target) {
                return mid;
            } else if (sum < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // java Solution.java "[2,7,11,15]" "9" "[1,2]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String numbers = args[i], target = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: numbers = %s, target = %s",
                string(new Solution().twoSum(intArr(numbers), Integer.parseInt(target))), expected, numbers, target));
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
