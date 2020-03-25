import java.util.Iterator;
import java.util.List;

class PeekingIterator implements Iterator<Integer> {

    private final Iterator<Integer> iterator;

    private Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        next = iterator.hasNext() ? iterator.next() : null;
    }

    public Integer peek() {
        return next;
    }

    @Override
	public Integer next() {
        Integer n = next;
        next = iterator.hasNext() ? iterator.next() : null;
        return n;
    }

    @Override
	public boolean hasNext() {
        return next != null;
	}

    public static void main(String... args) {
        var iterator = new PeekingIterator(List.of(1, 2, 3).iterator());
        System.out.println(String.format("Output: %s | Expected: %s", iterator.next(), 1));
        System.out.println(String.format("Output: %s | Expected: %s", iterator.peek(), 2));
        System.out.println(String.format("Output: %s | Expected: %s", iterator.next(), 2));
        System.out.println(String.format("Output: %s | Expected: %s", iterator.next(), 3));
        System.out.println(String.format("Output: %s | Expected: %s", iterator.hasNext(), false));
    }
}
