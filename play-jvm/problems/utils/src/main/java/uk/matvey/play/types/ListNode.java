package uk.matvey.play.types;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    public static ListNode listNode(Integer... vals) {
        if (vals == null || vals.length == 0) return null;
        var dummy = new ListNode(0);
        var node = dummy;
        for (var val : vals) {
            node.next = new ListNode(val);
            node = node.next;
        }
        return dummy.next;
    }
}
