import java.util.*;

class Solution {

    private static List<String> MONTHS = List.of("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

    public String reformatDate(String date) {
        var parts = date.split(" ");
        return year(parts[2]) + "-" + month(parts[1]) + "-" + day(parts[0]);
    }

    private String year(String s) {
        return s;
    }

    private String month(String s) {
        var month = MONTHS.indexOf(s) + 1;
        return month <= 9 ? "0" + month : "" + month;
    }

    private String day(String s) {
        var day = s.charAt(1) >= '0' && s.charAt(1) <= '9' ? s.substring(0, 2) : s.substring(0, 1);
        return day.length() == 1 ? "0" + day : day;
    }

    // java Solution.java "20th Oct 2052" "2052-10-20" "6th Jun 1933" "1933-06-06" "26th May 1960" "1960-05-26"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String date = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: date = %s",
                new Solution().reformatDate(date), expected, date));
        }
    }
}
