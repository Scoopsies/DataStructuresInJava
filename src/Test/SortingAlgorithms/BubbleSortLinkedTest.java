package Test.SortingAlgorithms;

import Main.MyLinkedList;
import SortingAlgorithms.BubbleSort;
import SortingAlgorithms.SortingContext;
import org.junit.jupiter.api.BeforeEach;

public class BubbleSortLinkedTest extends SortTest{

    @BeforeEach
    void setup() {
        controlList = new MyLinkedList();
        testList = new MyLinkedList();
        sort = new SortingContext(new BubbleSort());
    }
}
