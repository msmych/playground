import java.util.*;

class Solution {
    public String[] getFolderNames(String[] names) {
        var folderNames = new String[names.length];
        var map = new HashMap<String, Integer>();
        for (var i = 0; i < names.length; i++) {
            var name = names[i];
            if (map.containsKey(name)) {
                var j = map.get(name);
                while (map.containsKey(name + "(" + j + ")")) {
                    j++;
                }
                var folderName = name + "(" + j + ")";
                map.merge(name, 1, Integer::sum);
                map.putIfAbsent(folderName, 1);
                folderNames[i] = folderName;
            } else {
                folderNames[i] = names[i];
                map.put(names[i], 1);
            }
        }
        return folderNames;
    }

    // java Solution.java "[pes,fifa,gta,pes(2019)]" "[pes,fifa,gta,pes(2019)]" "[gta,gta(1),gta,avalon]" "[gta,gta(1),gta(2),avalon]" "[onepiece,onepiece(1),onepiece(2),onepiece(3),onepiece]" "[onepiece,onepiece(1),onepiece(2),onepiece(3),onepiece(4)]" "[wano,wano,wano,wano]" "[wano,wano(1),wano(2),wano(3)]" "[kaido,kaido(1),kaido,kaido(1)]" "[kaido,kaido(1),kaido(2),kaido(1)(1)]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String names = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: names = %s",
                string(new Solution().getFolderNames(array(names))), expected, names));
        }
    }

    private static String[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        return s.isEmpty() ? new String[0] : s.split(",");
    }

    private static String string(String[] arr) {
        var s = "";
        for (var e : arr) s += "," + e;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
