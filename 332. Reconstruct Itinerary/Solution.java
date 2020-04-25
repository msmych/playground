import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        return itinerary("JFK", tickets);
    }

    private List<String> itinerary(String from, List<List<String>> tickets) {
        if (tickets.size() == 1) {
            return tickets.get(0);
        }
        for (var ticket : tickets.stream()
            .filter(t -> t.get(0).equals(from))
            .sorted(comparing(t -> t.get(1)))
            .collect(toList())) {
            var nextTickets = new ArrayList<>(tickets);
            nextTickets.remove(ticket);
            var itinerary = itinerary(ticket.get(1), nextTickets);
            if (!itinerary.isEmpty()) {
                return Stream.concat(Stream.of(from), itinerary.stream()).collect(toList());
            }
        }
        return emptyList();
    }

    // java Solution.java "[[MUC, LHR], [JFK, MUC], [SFO, SJC], [LHR, SFO]]" "[JFK, MUC, LHR, SFO, SJC]" "[[JFK,SFO],[JFK,ATL],[SFO,ATL],[ATL,JFK],[ATL,SFO]]" "[JFK,ATL,JFK,SFO,ATL,SFO]" "[[JFK,KUL],[JFK,NRT],[NRT,JFK]]" "[JFK, NRT, JFK, KUL]" "[[EZE,AXA],[TIA,ANU],[ANU,JFK],[JFK,ANU],[ANU,EZE],[TIA,ANU],[AXA,TIA],[TIA,JFK],[ANU,TIA],[JFK,TIA]]" "[JFK,ANU,EZE,AXA,TIA,ANU,JFK,TIA,ANU,TIA,JFK]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String tickets = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: tickets = %s",
                new Solution().findItinerary(list(tickets)), expected, tickets));
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
