import java.util.*;

import static java.util.Comparator.*;

class MinStack {

    private final List<Integer> vals = new ArrayList<>();
    private final Queue<Integer> queue = new PriorityQueue<>(naturalOrder());

    public MinStack() {}

    public void push(int x) {
        vals.add(x);
        queue.add(x);
    }

    public void pop() {
        if (vals.isEmpty()) {
            return;
        }
        var v = vals.get(vals.size() - 1);
        vals.remove(vals.size() - 1);
        queue.remove(v);
    }

    public int top() {
        return vals.get(vals.size() - 1);
    }

    public int getMin() {
        return queue.peek();
    }
}
