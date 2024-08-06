package Test;

import Main.List;
import Main.MyArrayList;
import Main.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListTimesTest {
    private List arrayList;
    List linkedList;

    @BeforeEach
    void setup() {
        arrayList = new MyArrayList();
        linkedList = new MyLinkedList();
    }

    @Test
    void timeToAdd100000ToFrontOfList(){
        System.out.println("Front of List: ");
        System.out.print("ArrayList: ");
        add1000ToFrontOfList(arrayList);
        System.out.print("LinkedList: ");
        add1000ToFrontOfList(linkedList);
        System.out.println();
    }

    private void add1000ToFrontOfList(List list) {
        var startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.add(i, 0);
        }
        var endTime = System.currentTimeMillis();
        var timeTaken = endTime - startTime;
        System.out.println(timeTaken+" ms");
    }

    @Test
    void timeToAdd10000ToEndOfList(){
        System.out.println("End of List: ");
        System.out.print("ArrayList: ");
        add100000ToEndOfList(arrayList);
        System.out.print("LinkedList: ");
        add100000ToEndOfList(linkedList);
        System.out.println();
    }

    private void add100000ToEndOfList(List list) {
        var startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        var endTime = System.currentTimeMillis();
        var timeTaken = endTime - startTime;
        System.out.println(timeTaken+" ms");
    }

    @Test
    void timeToAdd10000ToMiddleOfList(){
        System.out.println("Middle of List: ");
        System.out.print("ArrayList: ");
        add100000ToMiddleOfList(arrayList);
        System.out.print("LinkedList: ");
        add100000ToMiddleOfList(linkedList);
        System.out.println();
    }

    private void add100000ToMiddleOfList(List list){
        list.add(1);
        list.add(1);
        var startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            var middleIndex = list.size() / 2;
            list.add(i, middleIndex);
        }
        var endTime = System.currentTimeMillis();
        var timeTaken = endTime - startTime;
        System.out.println(timeTaken+" ms");
    }
}
