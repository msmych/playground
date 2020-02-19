import static java.util.Comparator.reverseOrder;
import static java.util.Arrays.stream;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }
        Queue<Integer> queue = new PriorityQueue<>(reverseOrder());
        stream(target).forEach(queue::offer);
        long longSum = queue.stream().skip(1).mapToLong(n -> n).sum();
        if (longSum > Integer.MAX_VALUE) {
            return false;
        }
        int sum = (int) longSum;
        while (queue.peek() > 1) {
            Integer max = queue.poll();
            if (max > 2 * sum) {
                if (sum > 1 && max % (2 * sum) == 0) {
                    return false;
                }
                int next = max % (2 * sum);
                if (next < queue.peek()) {
                    sum = sum - queue.peek() + next;
                }
                queue.offer(next);
            } else {
                if (max <= sum) {
                    return false;
                }
                int next = max - sum;
                sum = sum - queue.peek() + next;
                queue.offer(next);
            }
        }
        return true;
    }

    // java Solution.java "[9,3,5]" "true" "[1,1,1,2]" "false" "[8,5]" "true" "[1,1000000000]" true "[2,900000001]" true "[1,1,999999999]" true "[2,900000002]" false "[5,50]" false
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String target = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: target = %s",
                new Solution().isPossible(array(target)), expected, target));
        }
    }

    private static int[] array(String s) {
        String[] elements = s.substring(1, s.length() - 1).replaceAll(" ", "").split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
