package uk.matvey.play.utils;

import java.io.IOException;

import static uk.matvey.play.utils.TestCaseParamsParser.TEST_CASE_PARAMS_PARSER;

public class TestCaseReader {

    private final String path;

    public TestCaseReader(String path) {
        this.path = path;
    }

    public String readString(String name) {
        try {
            return new String(this.getClass().getClassLoader().getResourceAsStream(path + "/" + name).readAllBytes())
                .replaceAll("^[ \\n\\r]+", "")
                .replaceAll("[ \\n\\r]+$", "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int[] parseIntArr(String name) {
        return TEST_CASE_PARAMS_PARSER.parseIntArr(readString(name));
    }

    public Integer[] parseIntegerArr(String name) {
        return TEST_CASE_PARAMS_PARSER.parseIntegerArr(readString(name));
    }

    public int[][] parseIntArrArr(String name) {
        return TEST_CASE_PARAMS_PARSER.parseIntIntArr(readString(name));
    }
}
