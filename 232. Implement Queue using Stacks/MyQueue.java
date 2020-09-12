import java.util.*;

class MyQueue {

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> backup = new Stack<>();

    public MyQueue() {}

    public void push(int x) {
        while (!stack.isEmpty()) {
            var val = stack.peek();
            stack.pop();
            backup.push(val);
        }
        backup.push(x);
        while (!backup.isEmpty()) {
            var val = backup.peek();
            backup.pop();
            stack.push(val);
        }
    }

    public int pop() {
        var val = stack.peek();
        stack.pop();
        return val;
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
