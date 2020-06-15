class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return nums1.length < nums2.length ? median(nums1, nums2) : median(nums2, nums1);
    }

    private double median(int[] a, int[] b) {
        int left = 0, right = a.length;
        while (left <= right) {
            int leftMid = left + (right - left) / 2, rightMid = (a.length + b.length + 1) / 2 - leftMid;
            if ((rightMid == 0 || leftMid == a.length || b[rightMid - 1] <= a[leftMid]) && (leftMid == 0 || leftMid == b.length || a[leftMid - 1] <= b[rightMid])) {
                int leftMax;
                if (leftMid == 0) {
                    leftMax = b[rightMid - 1];
                } else if (rightMid == 0) {
                    leftMax = a[leftMid - 1];
                } else {
                    leftMax = Math.max(a[leftMid - 1], b[rightMid - 1]);
                }
                if ((a.length + b.length) % 2 == 1) {
                    return leftMax;
                }
                int rightMin;
                if (leftMid == a.length) {
                    rightMin = b[rightMid];
                } else if (rightMid == b.length) {
                    rightMin = a[leftMid];
                } else {
                    rightMin = Math.min(a[leftMid], b[rightMid]);
                }
                return (leftMax + rightMin) / 2.0;
            } else if (leftMid < a.length && b[rightMid - 1] > a[leftMid]) {
                left = leftMid + 1;
            } else {
                right = leftMid - 1;
            }
        }
        return 0.0;
    }

    // java Solution.java "[1, 3]" "[2]" 2.0 "[1, 2]" "[3, 4]" 2.5
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String nums1 = args[i], nums2 = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums1 = %s, nums2 = %s",
                new Solution().findMedianSortedArrays(array(nums1), array(nums2)), expected, nums1, nums2));
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
