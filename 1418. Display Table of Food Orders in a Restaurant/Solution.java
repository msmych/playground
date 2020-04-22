import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.ArrayList;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        var food = orders.stream()
            .map(order -> order.get(2))
            .distinct()
            .sorted()
            .collect(toList());
        return Stream.concat(
            Stream.of(Stream.concat(Stream.of("Table"), food.stream()).collect(toList())), 
            orders.stream()
                .collect(groupingBy(order -> order.get(1),
                    groupingBy(order -> order.get(2), 
                        collectingAndThen(counting(), Long::intValue))))
                .entrySet().stream()
                .sorted(comparingInt(e -> Integer.parseInt(e.getKey())))
                .map(e -> Stream.concat(Stream.of(e.getKey()), 
                    food.stream()
                        .map(item -> e.getValue().getOrDefault(item, 0))
                        .map(Object::toString))
                        .collect(toList())))
            .collect(toList());
    }

    // java Solution.java "[[David,3,Ceviche],[Corina,10,Beef Burrito],[David,3,Fried Chicken],[Carla,5,Water],[Carla,5,Ceviche],[Rous,3,Ceviche]]" "[[Table,Beef Burrito,Ceviche,Fried Chicken,Water],[3,0,2,1,0],[5,0,1,0,1],[10,1,0,0,0]]" "[[James,12,Fried Chicken],[Ratesh,12,Fried Chicken],[Amadeus,12,Fried Chicken],[Adam,1,Canadian Waffles],[Brianna,1,Canadian Waffles]]" "[[Table,Canadian Waffles,Fried Chicken],[1,2,0],[12,0,3]]" "[[Laura,2,Bean Burrito],[Jhon,2,Beef Burrito],[Melissa,2,Soda]]" "[[Table,Bean Burrito,Beef Burrito,Soda],[2,1,1,1]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String orders = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: orders = %s",
                new Solution().displayTable(list(orders)), expected, orders));
        }
    }

    private static List<List<String>> list(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return List.of();
        var rows = s.substring(1, s.length() - 1).split("\\],\\[");
        if (rows[0].isEmpty()) return List.of();
        var list = new ArrayList<List<String>>();
        for (var i = 0; i < rows.length; i++) {
            var elements = rows[i].split(",");
            var row = new ArrayList<String>();
            for (var j = 0; j < elements.length; j++)
                row.add(elements[j]);
            list.add(row);
        }
        return list;
    }
}
