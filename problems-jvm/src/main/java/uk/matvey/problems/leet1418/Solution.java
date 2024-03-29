package uk.matvey.problems.leet1418;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public List<List<String>> displayTable(List<List<String>> orders) {
        var food = orders.stream()
            .map(order -> order.get(2))
            .distinct()
            .sorted()
            .toList();
        return Stream.concat(
                Stream.of(Stream.concat(Stream.of("Table"), food.stream()).collect(Collectors.toList())),
                orders.stream()
                    .collect(Collectors.groupingBy(order -> order.get(1),
                        Collectors.groupingBy(order -> order.get(2),
                            Collectors.collectingAndThen(Collectors.counting(), Long::intValue))))
                    .entrySet().stream()
                    .sorted(Comparator.comparingInt(e -> Integer.parseInt(e.getKey())))
                    .map(e -> Stream.concat(Stream.of(e.getKey()),
                            food.stream()
                                .map(item -> e.getValue().getOrDefault(item, 0))
                                .map(Object::toString))
                        .collect(Collectors.toList())))
            .collect(Collectors.toList());
    }
}

class SolutionTest {

    @Test
    void case1() {
        var orders = List.of(List.of("David", "3", "Ceviche"), List.of("Corina", "10", "Beef Burrito"), List.of("David", "3", "Fried Chicken"), List.of("Carla", "5", "Water"), List.of("Carla", "5", "Ceviche"), List.of("Rous", "3", "Ceviche"));

        final var result = new Solution().displayTable(orders);

        assertThat(result).containsExactly(List.of("Table", "Beef Burrito", "Ceviche", "Fried Chicken", "Water"), List.of("3", "0", "2", "1", "0"), List.of("5", "0", "1", "0", "1"), List.of("10", "1", "0", "0", "0"));
    }

    @Test
    void case2() {
        var orders = List.of(List.of("James", "12", "Fried Chicken"), List.of("Ratesh", "12", "Fried Chicken"), List.of("Amadeus", "12", "Fried Chicken"), List.of("Adam", "1", "Canadian Waffles"), List.of("Brianna", "1", "Canadian Waffles"));

        final var result = new Solution().displayTable(orders);

        assertThat(result).containsExactly(List.of("Table", "Canadian Waffles", "Fried Chicken"), List.of("1", "2", "0"), List.of("12", "0", "3"));
    }

    @Test
    void case3() {
        var orders = List.of(List.of("Laura","2","Bean Burrito"),List.of("Jhon","2","Beef Burrito"),List.of("Melissa","2","Soda"));

        final var result = new Solution().displayTable(orders);

        assertThat(result).containsExactly(List.of("Table", "Bean Burrito", "Beef Burrito", "Soda"), List.of("2", "1", "1", "1"));
    }
}