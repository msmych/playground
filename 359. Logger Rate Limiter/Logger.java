import java.util.*;

class Logger {

    private final Map<String, Integer> lastMessages = new HashMap<>();

    public Logger() {}

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!lastMessages.containsKey(message)) {
            lastMessages.put(message, timestamp);
            return true;
        }
        if (timestamp - lastMessages.get(message) >= 10) {
            lastMessages.put(message, timestamp);
            return true;
        }
        return false;
    }

    public static void main(String... args) {
        var logger = new Logger();
        System.out.println(String.format("Output: %s | Expected: %s", logger.shouldPrintMessage(1, "foo"), true));
        System.out.println(String.format("Output: %s | Expected: %s", logger.shouldPrintMessage(2, "bar"), true));
        System.out.println(String.format("Output: %s | Expected: %s", logger.shouldPrintMessage(3, "foo"), false));
        System.out.println(String.format("Output: %s | Expected: %s", logger.shouldPrintMessage(8, "bar"), false));
        System.out.println(String.format("Output: %s | Expected: %s", logger.shouldPrintMessage(10, "foo"), false));
        System.out.println(String.format("Output: %s | Expected: %s", logger.shouldPrintMessage(11, "foo"), true));
    }
}
