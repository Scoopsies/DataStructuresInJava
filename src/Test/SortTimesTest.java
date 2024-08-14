package Test;

import Main.List;
import Main.MyArrayList;
import Main.MyLinkedList;
import SortingAlgorithms.BubbleSort;
import SortingAlgorithms.MergeSort;
import SortingAlgorithms.QuickSort;
import SortingAlgorithms.SortingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortTimesTest {
    private List arrayList;
    private List linkedList;

    @BeforeEach
    void setup() {
        arrayList = new MyArrayList();
        add10000RandomIntsTo(arrayList);
        linkedList = new MyLinkedList();
        add10000RandomIntsTo(linkedList);
    }

    @Test
    void quickSortArrayList(){
        var mergeSort = new SortingContext(new QuickSort());
        System.out.println("Quick Sort:");
        System.out.print("Array List: ");
        printSortTime(arrayList, mergeSort);
    }

    @Test
    void quickSortLinkedList(){
        var mergeSort = new SortingContext(new QuickSort());
        System.out.println("Quick Sort:");
        System.out.print("Linked List: ");
        printSortTime(linkedList, mergeSort);
    }

    @Test
    void mergeSortArrayList(){
        var mergeSort = new SortingContext(new MergeSort());
        System.out.println("Merge Sort:");
        System.out.print("Array List: ");
        printSortTime(arrayList, mergeSort);
    }

    @Test
    void mergeSortLinkedList(){
        var mergeSort = new SortingContext(new MergeSort());
        System.out.println("Merge Sort:");
        System.out.print("Linked List: ");
        printSortTime(arrayList, mergeSort);
    }

    @Test
    void bubbleSortArrayList(){
        var bubbleSort = new SortingContext(new BubbleSort());
        System.out.println("Bubble Sort:");
        System.out.print("Array List: ");
        printSortTime(arrayList, bubbleSort);
    }

    @Test
    void bubbleSortLinkedList() {
        var bubbleSort = new SortingContext(new BubbleSort());
        System.out.println("Bubble Sort:");
        System.out.print("Linked List: ");
        printSortTime(linkedList, bubbleSort);
    }

    void printSortTime(List list, SortingContext sort) {
        var startTime = System.currentTimeMillis();
        sort.sort(list);
        var endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " ms");
    }

    void add10000RandomIntsTo(List list) {
        for (int i = 0; i < 10000; i++) {
            int randomInt = (int) (Math.random() * 100);
            list.add(randomInt);
        }
    }
}
