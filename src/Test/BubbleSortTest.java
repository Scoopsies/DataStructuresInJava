package Test;

import Main.List;
import Main.MyArrayList;
import SortingAlgorithms.Sort;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleSortTest {
    private List controlList;
    private List testList;

    @BeforeEach
    void setup() {
        controlList = new MyArrayList();
        testList = new MyArrayList();
    }

    @Test
    void sortsSortedList() {
        getRange(10, controlList);
        var testedArray = new MyArrayList();
        getRange(10, testedArray);
        Sort.bubbleSort(testedArray);
        assertListEquals(controlList, testedArray);
    }

    @Test
    void sortsEmptyList() {
        Sort.bubbleSort(testList);
        assertListEquals(controlList, testList);
    }

    @Test
    public void sortsSingleElement() {
        getRange(1, testList);
        getRange(1, controlList);
        Sort.bubbleSort(testList);
        assertListEquals(controlList, testList);
    }

    @Test
    public void sortsReversedList() {
        getReverseRange(5, testList);
        getRange(5, controlList);
        Sort.bubbleSort(testList);
        assertListEquals(controlList, testList);
    }

    @Test
    public void sortsListWithDuplicates() {
        getDupedRange(10, controlList);
        getDupedReverseRange(10, testList);
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

    void getDupedRange(int n, List list) {
        for (int i = 0; i < n; i++) {
            list.add(i);
            list.add(i);
        }

    }

    void getReverseRange(int n, List list) {
        for (int i = n - 1; i >= 0; i--) {
            list.add(i);
        }
    }

    void getDupedReverseRange(int n, List list) {
        for (int i = n - 1; i >= 0; i--) {
            list.add(i);
            list.add(i);
        }

    }
}
