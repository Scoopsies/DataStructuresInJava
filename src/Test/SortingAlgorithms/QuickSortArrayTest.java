package Test.SortingAlgorithms;

import Main.MyArrayList;
import SortingAlgorithms.QuickSort;
import SortingAlgorithms.SortingContext;
import org.junit.jupiter.api.BeforeEach;

public class QuickSortArrayTest extends  SortTest{
    @Override
    @BeforeEach
    void setup() {
        list = new MyArrayList();
        sort = new SortingContext(new QuickSort());
    }
}
