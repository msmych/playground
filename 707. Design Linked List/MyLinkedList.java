class MyLinkedList {
    
    private Entry head;

    private static class Entry {

        Entry previous, next;
        int val;

        Entry (int val) {
            this.val = val;
        }
    }

    public MyLinkedList() {}
    
    public int get(int index) {
        if (head == null) {
            return -1;
        }
        var entry = head;
        for (var i = 0; i < index; i++) {
            if (entry != null) {
                entry = entry.next;
            } else {
                return -1;
            }
        }
        return entry != null ? entry.val : -1;
    }
    
    public void addAtHead(int val) {
        var entry = new Entry(val);
        entry.next = head;
        if (head != null) {
            head.previous = entry;
        }
        head = entry;
    }
    
    public void addAtTail(int val) {
        var entry = new Entry(val);
        if (head == null) {
            head = entry;
        }
        var tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = entry;
        entry.previous = tail;
    }
    
    public void addAtIndex(int index, int val) {
        var entry = new Entry(val);
        if (index == 0) {
            if (head == null) {
                head = entry;
            } else {
                entry.next = head.next;
                head = entry;
            }
            return;
        }
        var old = head;
        for (var i = 1; i < index; i++) {
            if (old != null) {
                old = old.next;
            } else {
                return;
            }
        }
        if (old == null) {
            return;
        }
        var next = old.next;
        entry.next = next;
        if (next != null) {
            next.previous = entry;
        }
        old.next = entry;
        entry.previous = old;
    }
    
    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }
        if (index == 0) {
            head = head.next;
            head.previous = null;
        }
        var entry = head;
        for (var i = 0; i < index; i++) {
            if (entry != null) {
                entry = entry.next;
            }
        }
        if (entry == null) {
            return;
        }
        Entry previous = entry.previous, next = entry.next;
        previous.next = next;
        if (next != null) {
            next.previous = previous;
        }
    }

    public static void main(String... args) {
        var list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        System.out.println(String.format("Output: %s | Expected: %s", list.get(1), 2));
        list.deleteAtIndex(1);
        System.out.println(String.format("Output: %s | Expected: %s", list.get(1), 3));
    }
}

