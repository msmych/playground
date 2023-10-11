package uk.matvey.play.utils;

import java.io.IOException;

public class CaseParamsReader {

    public static CaseParamsReader CASE_PARAMS_READER = new CaseParamsReader();

    public String readString(String path) {
        try {
            return new String(this.getClass().getClassLoader().getResourceAsStream(path).readAllBytes())
                .replaceAll("^[ \\n\\r]+", "")
                .replaceAll("[ \\n\\r]+$", "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
        String[] parts = str.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = parseInt(parts[i]);
        }
        return arr;
    }

    public int[][] parseIntArrArr(String str) {
        if (str.startsWith("[[")) {
            str = str.substring(2);
        }
        if (str.endsWith("]]")) {
            str = str.substring(0, str.length() - 2);
        }
        String[] parts = str.split("], *\\[");
        int[][] arr = new int[parts.length][];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = parseIntArr(parts[i]);
        }
        return arr;
    }
}
