class NumMatrix {
    public NumMatrix(int[][] matrix) {

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return 0;
    }

    public static void main(String... args) {
        var matrix = new NumMatrix(new int[][]{
            {3,0,1,4,2},
            {5,6,3,2,1},
            {1,2,0,1,5},
            {4,1,0,1,7},
            {1,0,3,0,5}
        });
        System.out.println(String.format("Output: %s | Expected: %s", matrix.sumRegion(2, 1, 4, 3), 8));
        System.out.println(String.format("Output: %s | Expected: %s", matrix.sumRegion(1, 1, 2, 2), 11));
        System.out.println(String.format("Output: %s | Expected: %s", matrix.sumRegion(1, 2, 2, 4), 12));
    }
}
