import java.util.*;

class MyStack {

    private final Queue<Integer> queue = new LinkedList<>();

    public MyStack() {}

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        var backup = new LinkedList<Integer>();
        while (true) {
            var val = queue.poll();
            backup.offer(val);
            if (queue.isEmpty()) {
                while (true) {
                    var v = backup.poll();
                    if (backup.isEmpty()) {
                        return val;
                    }
                    queue.offer(v);
                }
            }
        }
    }

    public int top() {
        var backup = new LinkedList<Integer>();
        var val = 0;
        while (!queue.isEmpty()) {
            val = queue.poll();
            backup.offer(val);
        }
        while (!backup.isEmpty()) {
            queue.offer(backup.poll());
        }
        return val;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
