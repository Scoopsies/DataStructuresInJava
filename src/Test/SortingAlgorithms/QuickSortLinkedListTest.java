package Test.SortingAlgorithms;

import Main.MyLinkedList;
import SortingAlgorithms.QuickSort;
import SortingAlgorithms.SortingContext;
import org.junit.jupiter.api.BeforeEach;

public class QuickSortLinkedListTest extends SortTest{
    @Override
    @BeforeEach
    void setup() {
        list = new MyLinkedList();
        sort = new SortingContext(new QuickSort());
    }
}
