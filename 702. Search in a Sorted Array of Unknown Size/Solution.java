class Solution {

    public int search(ArrayReader reader, int target) {
        int left = 0, right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            var n = reader.get(mid);
            if (n == target) {
                return mid;
            } else if (n < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String... args) {
        for (var i = 0; i < args.length; i += 3) {
            var reader = new ArrayReader(intArr(args[i]));
            String target = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: array = %s, target = %s",
                new Solution().search(reader, Integer.parseInt(target)), expected, args[i], target));
        }
    }

    // java Solution.java "[-1,0,3,5,9,12]" 9 4 "[-1,0,3,5,9,12]" 2 -1
    private static int[] intArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}

class ArrayReader {

    private final int[] arr;

    ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        return index >= arr.length ? Integer.MAX_VALUE : arr[index];
    }
}
