package Test.SortingAlgorithms;

import Main.MyLinkedList;
import SortingAlgorithms.MergeSort;
import SortingAlgorithms.SortingContext;
import org.junit.jupiter.api.BeforeEach;

public class MergeSortLinkedTest extends SortTest{
    @Override
    @BeforeEach
    void setup() {
        list = new MyLinkedList();
        sort = new SortingContext(new MergeSort());
    }
}
