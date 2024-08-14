package Test.SortingAlgorithms;

import Main.List;
import SortingAlgorithms.SortingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class SortTest {
    protected List list;
    protected SortingContext sort;

    @BeforeEach
    abstract void setup();

    @Test
    public void sortedListIsSameSizeAsOriginal() {
        addReverseRange(20, list);
        var preSortedSize = list.size();
        sort.sort(list);
        var postSortedSize = list.size();
        assertEquals(preSortedSize, postSortedSize);
    }

    @Test
    void sortsSortedList() {
        addRange(20, list);
        assertSorted(list);
    }

    @Test
    void sortsEmptyList() {
        sort.sort(list);
        assertSorted(list);
    }

    @Test
    public void sortsSingleElement() {
        addRange(1, list);
        sort.sort(list);
        assertSorted(list);
    }

    @Test
    public void sortsReversedList() {
        addReverseRange(10, list);
        sort.sort(list);
        assertSorted(list);
    }

    @Test
    public void sortsListWithDuplicates() {
        addReverseRange(20, list);
        addReverseRange(20, list);
        sort.sort(list);
        assertSorted(list);
    }

    @Test
    public void sortsListWithNegatives() {
        addRandomNegatives(list);
        sort.sort(list);
        assertSorted(list);
    }

    void assertSorted(List list) {
        boolean isSorted = true;
        int lastValue = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            var currentValue = list.get(i);
            if (lastValue > currentValue) {
                isSorted = false;
            }
            lastValue = currentValue;
        }
        assertTrue(isSorted);
    }

    void addRange(int n, List list) {
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
    }

    void addReverseRange(int n, List list) {
        for (int i = 0; i < n; i++) {
            list.add(i, 0);
        }
    }

    void addRandomNegatives(List list) {
        for (int i = 0; i < 20; i++) {
            var randomInt = (int) (Math.random() * -100);
            list.add(randomInt);
        }
    }
}
