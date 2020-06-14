class SubrectangleQueries {

    private final int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle; 
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (var i = row1; i <= row2; i++) {
            for (var j = col1; j <= col2; j++) {
                rectangle[i][j] = newValue;
            }
        }
    }
    
    public int getValue(int row, int col) {
        return rectangle[row][col];
    }

    public static void main(String... args) {
        var queries = new SubrectangleQueries(new int[][]{{1,2,1},{4,3,4},{3,2,1},{1,1,1}});
        System.out.println(String.format("Output: %s | Expected: %s", queries.getValue(0, 2), 1));
        queries.updateSubrectangle(0,0,3,2,5);
        System.out.println(String.format("Output: %s | Expected: %s", queries.getValue(0, 2), 5));
        System.out.println(String.format("Output: %s | Expected: %s", queries.getValue(3, 1), 5));
        queries.updateSubrectangle(3,0,3,2,10);
        System.out.println(String.format("Output: %s | Expected: %s", queries.getValue(3, 1), 10));
        System.out.println(String.format("Output: %s | Expected: %s", queries.getValue(0, 2), 5));
    }
}
