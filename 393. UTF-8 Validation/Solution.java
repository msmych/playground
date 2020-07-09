class Solution {
    public boolean validUtf8(int[] data) {
        if (data.length == 0 || data.length > 4) {
            return false;
        }
        if (data.length == 1) {
            return (data[0] & (1 << 7)) == 0;
        }
        for (var i = 0; i < data.length; i++) {
            if ((data[0] & (1 << (7 - i))) == 0) {
                return false;
            }
        }
        if ((data[0] & (1 << (7 - data.length))) != 0) {
            return false;
        }
        for (var i = 1; i < data.length; i++) {
            if ((data[i] & (1 << 7)) == 0) {
                return false;
            }
            if ((data[i] & (1 << 6)) != 0) {
                return false;
            }
        }
        return true;
    }

    // java Solution.java "[197, 130, 1]" "true" "[235, 140, 4]" "false"
    public static void main(String... args) {
        new Solution().validUtf8(array("[197, 130, 1]"));
        for (int i = 0; i < args.length; i += 2) {
            String data = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: data = %s",
                new Solution().validUtf8(array(data)), expected, data));
        }
    }

    private static int[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
