package Test.SortingAlgorithms;

import Main.List;
import Main.MyArrayList;
import SortingAlgorithms.SortingContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class SortTest {
    protected List controlList;
    protected List testList;
    protected SortingContext sort;

    abstract void setup();

    @Test
    void sortsSortedList() {
        getRange(10, controlList);
        var testedArray = new MyArrayList();
        getRange(10, testedArray);
        sort.sort(testedArray);
        assertListEquals(controlList, testedArray);
    }

    @Test
    void sortsEmptyList() {
        sort.sort(testList);
        assertListEquals(controlList, testList);
    }

    @Test
    public void sortsSingleElement() {
        getRange(1, testList);
        getRange(1, controlList);
        sort.sort(testList);
        assertListEquals(controlList, testList);
    }

    @Test
    public void sortsReversedList() {
        getReverseRange(testList);
        getRange(5, controlList);
        sort.sort(testList);
        assertListEquals(controlList, testList);
    }

    @Test
    public void sortsListWithDuplicates() {
        getDupedRange(controlList);
        getDupedReverseRange(testList);
    }

    void assertListEquals(List list, List sortedList) {
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i), sortedList.get(i));
        }
        assertEquals(list.size(), sortedList.size());
    }

    void getRange(int n, List list) {
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
    }

    void getDupedRange(List list) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
            list.add(i);
        }

    }

    void getReverseRange(List list) {
        for (int i = 0; i < 5; i++) {
            list.add(i, 0);
        }
    }

    void getDupedReverseRange(List list) {
        for (int i = 0; i < 10; i++) {
            list.add(i, 0);
            list.add(i, 0);
        }

    }
}
