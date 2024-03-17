package uk.matvey.problems.leet;

public class TestCaseParamsParser {

    public static TestCaseParamsParser TEST_CASE_PARAMS_PARSER = new TestCaseParamsParser();

    public int parseInt(String str) {
        return Integer.parseInt(str.trim());
    }

    public int[] parseIntArr(String str) {
        if (str.startsWith("[")) {
            str = str.substring(1);
        }
        if (str.endsWith("]")) {
            str = str.substring(0, str.length() - 1);
        }
        var parts = str.split(",");
        var arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = parseInt(parts[i]);
        }
        return arr;
    }

    public Integer[] parseIntegerArr(String str) {
        if (str.startsWith("[")) {
            str = str.substring(1);
        }
        if (str.endsWith("]")) {
            str = str.substring(0, str.length() - 1);
        }
        var parts = str.split(",");
        var arr = new Integer[parts.length];
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("null")) {
                continue;
            }
            arr[i] = parseInt(parts[i]);
        }
        return arr;
    }

    public int[][] parseIntIntArr(String str) {
        if (str.startsWith("[[")) {
            str = str.substring(2);
        }
        if (str.endsWith("]]")) {
            str = str.substring(0, str.length() - 2);
        }
        var parts = str.split("], *\\[");
        var arr = new int[parts.length][];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = parseIntArr(parts[i]);
        }
        return arr;
    }
}
