package Test.SortingAlgorithms;

import Main.MyArrayList;
import SortingAlgorithms.MergeSort;
import SortingAlgorithms.SortingContext;
import org.junit.jupiter.api.BeforeEach;

public class MergeSortArrayTest extends SortTest{

    @BeforeEach
    void setup() {
        controlList = new MyArrayList();
        testList = new MyArrayList();
        sort = new SortingContext(new MergeSort());
    }
}
