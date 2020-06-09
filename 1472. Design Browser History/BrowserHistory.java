import java.util.*;

import static java.lang.Math.*;

class BrowserHistory {

    private final List<String> history = new ArrayList<>();
    private int index = 0;

    public BrowserHistory(String homepage) {
        history.add(homepage); 
    }
    
    public void visit(String url) {
        index++;
        while (history.size() > index) {
            history.remove(index);
        }
        history.add(url);
    }
    
    public String back(int steps) {
        index = max(index - steps, 0);
        return history.get(index);
    }
    
    public String forward(int steps) {
        index = min(index + steps, history.size() - 1);
        return history.get(index);
    }

    public static void main(String... args) {
        var history = new BrowserHistory("leetcode.com");
        history.visit("google.com");
        history.visit("facebook.com");
        history.visit("youtube.com");
        System.out.println(String.format("Output: %s | Expected: %s", history.back(1), "facebook.com"));
        System.out.println(String.format("Output: %s | Expected: %s", history.back(1), "google.com"));
        System.out.println(String.format("Output: %s | Expected: %s", history.forward(1), "facebook.com"));
        history.visit("linkedin.com");
        System.out.println(String.format("Output: %s | Expected: %s", history.forward(2), "linkedin.com"));
        System.out.println(String.format("Output: %s | Expected: %s", history.back(2), "google.com"));
        System.out.println(String.format("Output: %s | Expected: %s", history.back(7), "leetcode.com"));
    }
}
