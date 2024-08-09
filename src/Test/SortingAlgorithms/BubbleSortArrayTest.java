package Test.SortingAlgorithms;

import SortingAlgorithms.BubbleSort;
import SortingAlgorithms.SortingContext;
import org.junit.jupiter.api.BeforeEach;
import Main.MyArrayList;

public class BubbleSortArrayTest extends SortTest {

    @BeforeEach
    void setup() {
        list = new MyArrayList();
        sort = new SortingContext(new BubbleSort());
    }
}