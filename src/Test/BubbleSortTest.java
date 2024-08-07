package Test;

import Main.List;
import Main.MyArrayList;
import SortingAlgorithms.BubbleSort;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleSortTest {
    private List list;

    @BeforeEach
    void setup() {
        list = new MyArrayList();
    }

    @Test
    void alreadySortedListReturnsItself() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        var sortedList = BubbleSort.sort(list);
        assertListEquals(list, sortedList);
    }



    void assertListEquals(List list, List sortedList) {
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i), sortedList.get(i));
        }
        assertEquals(list.size(), sortedList.size());
    }
}
