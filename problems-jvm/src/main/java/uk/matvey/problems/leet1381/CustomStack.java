package uk.matvey.problems.leet1381;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

}

class CustomStackTest {

    @Test
    void case1() {
        var stack = new CustomStack(3);

        stack.push(1);
        stack.push(2);

        assertThat(stack.pop()).isEqualTo(2);

        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.increment(5, 100);
        stack.increment(2, 100);

        assertThat(stack.pop()).isEqualTo(103);
        assertThat(stack.pop()).isEqualTo(202);
        assertThat(stack.pop()).isEqualTo(201);
        assertThat(stack.pop()).isEqualTo(-1);
    }
}
