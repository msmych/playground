class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (var i = 0; i < gas.length; i++) {
            var canFinish = true;
            var g = 0;
            for (var j = 0; j < gas.length; j++) {
                g += gas[(i + j) % gas.length];
                g -= cost[(i + j) % cost.length];
                if (g < 0) {
                    canFinish = false;
                    break;
                }
            }
            if (canFinish) {
                return i;
            }
        }
        return -1;
    }

    // java Solution.java "[1,2,3,4,5]" "[3,4,5,1,2]" "3" "[2,3,4]" "[3,4,3]" "-1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String gas = args[i], cost = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: gas = %s, cost = %s",
                new Solution().canCompleteCircuit(intArr(gas), intArr(cost)), expected, gas, cost));
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
}
