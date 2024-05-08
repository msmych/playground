package uk.matvey.problems.leet1452;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        var hashCompanies = favoriteCompanies.stream()
            .map(companies -> companies.stream()
                .map(Object::hashCode)
                .sorted()
                .toList())
            .toList();
        var people = new ArrayList<Integer>();
        for (int i = 0; i < hashCompanies.size(); i++) {
            var favorite = hashCompanies.get(i);
            if (hashCompanies.stream()
                .filter(Predicate.not(favorite::equals))
                .noneMatch(companies -> isSubset(favorite, companies))) {
                people.add(i);
            }
        }
        return people;
    }

    private boolean isSubset(List<Integer> a, List<Integer> b) {
        if (a.equals(b)) {
            return true;
        }
        if (a.size() > b.size()) {
            return false;
        }
        int i = 0;
        for (int j = 0; i < a.size() && j < b.size(); j++) {
            if (a.get(i).equals(b.get(j))) {
                i++;
            } else if (b.get(j) > a.get(i)) {
                return false;
            }
        }
        return i == a.size();
    }
}

class SolutionTest {

    @Test
    void case1() {
        var favoriteCompanies = List.of(
            List.of("leetcode", "google", "facebook"),
            List.of("google", "microsoft"),
            List.of("google", "facebook"),
            List.of("google"),
            List.of("amazon")
        );

        var result = new Solution().peopleIndexes(favoriteCompanies);

        assertThat(result).containsExactly(0, 1, 4);
    }

    @Test
    void case2() {
        var favoriteCompanies = List.of(
            List.of("leetcode", "google", "facebook"), List.of("leetcode", "amazon"), List.of("facebook", "google")
        );

        var result = new Solution().peopleIndexes(favoriteCompanies);

        assertThat(result).containsExactly(0, 1);
    }

    @Test
    void case3() {
        var favoriteCompanies = List.of(
            List.of("leetcode"), List.of("google"), List.of("facebook"), List.of("amazon")
        );

        var result = new Solution().peopleIndexes(favoriteCompanies);

        assertThat(result).containsExactly(0, 1, 2, 3);
    }
}
