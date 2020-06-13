import java.util.*;
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        var stack = new Stack<NestedInteger>();
        NestedInteger ni = null;
        var sb = new StringBuilder();
        for (var c : s.toCharArray()) {
            switch (c) {
                case '[':
                    stack.push(new NestedInteger());
                    break;
                case ']':
                    if (sb.length() > 0) {
                        ni = new NestedInteger(Integer.parseInt(sb.toString()));
                    }
                    var parent = stack.pop();
                    if (ni != null) {
                        parent.add(ni);
                    }
                    ni = parent;
                    sb = new StringBuilder();
                    break;
                case ',':
                    if (sb.length() > 0) {
                        ni = new NestedInteger(Integer.parseInt(sb.toString()));
                    }
                    stack.peek().add(ni);
                    ni = null;
                    sb = new StringBuilder();
                    break;
                default:
                    sb.append(c);   
            }
        }
        if (sb.length() > 0) {
            ni = new NestedInteger(Integer.parseInt(sb.toString()));
        }
        return ni;
    }

    public static void main(String... args) {
        new Solution().deserialize("[123,[456,[789]]]");
    }
}

class NestedInteger {
    OptionalInt num = OptionalInt.empty();
    List<NestedInteger> list = new ArrayList<>();

    NestedInteger() {}

    NestedInteger(int i) {
        num = OptionalInt.of(i);
    }

    void setInteger(int i) {
        num = OptionalInt.of(i);
    }

    void add(NestedInteger ni) {
        list.add(ni);
    }
}