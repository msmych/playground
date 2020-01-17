import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class NestedIterator implements Iterator<Integer> {

    private final Queue<Integer> queue = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        nestedList.stream().flatMap(this::flatten).forEach(queue::offer);
    }

    private Stream<Integer> flatten(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            return Stream.of(nestedInteger.getInteger());
        }
        return nestedInteger.getList().stream().flatMap(this::flatten);
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

interface NestedInteger {

    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}