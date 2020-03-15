class CustomStack {

    private final int[] vals;

    private int head = -1;

    public CustomStack(int maxSize) {
        vals = new int[maxSize]; 
    }
    
    public void push(int x) {
        if (head < vals.length - 1) {
            vals[++head] = x;
        }
    }
    
    public int pop() {
        return head > -1 ? vals[head--] : -1;
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < k && i <= head; i++) {
            vals[i] += val;
        }
    }

    public static void main(String... args) {
        var stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        System.out.println(String.format("Output: %s | Expected: %s", stack.pop(), 2));
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.increment(5, 100);
        stack.increment(2, 100);
        System.out.println(String.format("Output: %s | Expected: %s", stack.pop(), 103));
        System.out.println(String.format("Output: %s | Expected: %s", stack.pop(), 202));
        System.out.println(String.format("Output: %s | Expected: %s", stack.pop(), 201));
        System.out.println(String.format("Output: %s | Expected: %s", stack.pop(), -1));
    }

}
