class Solution {
    public int[] sortArrayByParity(int[] A) {
        for (int fast = 0, slow = -1; fast < A.length; fast++) {
            if (A[fast] % 2 == 0) {
                if (slow != -1) {
                    var n = A[slow];
                    A[slow] = A[fast];
                    A[fast] = n;
                    for (; slow <= fast; slow++) {
                        if (A[slow] % 2 == 1) {
                            break;
                        }
                    }
                }
            } else if (slow == -1) {
                slow = fast;
            }
        }
        return A;
    }

    // java Solution.java "[3,1,2,4]" "[2,4,3,1]" "[0]" "[0]" "[1]" "[1]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String A = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: A = %s",
                string(new Solution().sortArrayByParity(array(A))), expected, A));
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

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
