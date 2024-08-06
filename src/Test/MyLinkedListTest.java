package Test;

import Main.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest {
    private  MyLinkedList linkedList;

    @BeforeEach
    void setup(){
        linkedList = new MyLinkedList();
    }

    @Test
    void newLinkHas0size() {
        assertEquals(0, linkedList.size());
    }

    @Test
    void addsOneItem() {
        linkedList.add(1);
        assertEquals(1, linkedList.get(0));
    }

    @Test
    void addsTwoItems() {
        addXTimes(2);
        assertEquals(1, linkedList.get(1));
    }

    @Test
    void addsThreeItems() {
        addXTimes(3);
        assertEquals(2, linkedList.get(2));
    }

    @Test
    void addsToTheMiddle(){
        addXTimes(10);
        assertEquals(3, linkedList.get(3));

        linkedList.add(20, 3);
        assertEquals(20, linkedList.get(3));
    }

    @Test
    void addsToBeginning1000Times(){
        for (int i = 0; i < 1000; i++) {
            linkedList.add(i, 0);
        }

        var index = 0;
        for (int i = 999; i >= 0; i--) {
            assertEquals(i, linkedList.get(index));
            index++;
        }
    }

    @Test
    void addsToEndWithIndex(){
        addXTimes(5);
        assertEquals(5, linkedList.size());
        linkedList.add(5, 5);
        assertEquals(5, linkedList.get(5));
    }

    @Test
    void sizeIncreasesWhenAddingItemsToFront() {
        addXTimes(10);
        linkedList.add(20, 0);
        assertEquals(11, linkedList.size());
    }

    @Test
    void sizeIncreasesWhenAddingItemsToMiddle() {
        addXTimes(10);
        linkedList.add(20, 5);
        assertEquals(11, linkedList.size());
    }

    @Test
    void sizeIncreasesWhenAddingItemsToEnd() {
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
            assertEquals(i + 1, linkedList.size());
        }
    }

    @Test
    void getReturnsFirstItem() {
        addXTimes(10);
        assertEquals(0, linkedList.get(0));
    }

    @Test
    void getReturnsMiddleItem() {
        addXTimes(10);
        assertEquals(2, linkedList.get(2));
    }

    @Test
    void getReturnsLastItem() {
        addXTimes(10);
        assertEquals(4, linkedList.get(4));
    }

    @Test
    void removesFromFront() {
        addXTimes(5);
        linkedList.remove(0);
        assertEquals(1, linkedList.get(0));
    }

    @Test
    void removesFromMiddle() {
        addXTimes(10);
        assertEquals(3, linkedList.get(3));
        linkedList.remove(3);
        assertEquals(4, linkedList.get(3));
    }

    @Test
    void removesFromBack() {
        addXTimes(10);
        assertEquals(9, linkedList.get(9));
        linkedList.remove(9);
        linkedList.add(15);
        assertEquals(15, linkedList.get(9));
    }

    @Test
    void getThrowsErrorIfOutOfBounds(){
        addXTimes(10);
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(10));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
    }

    @Test
    void addThrowsErrorIfOutOfBounds(){
        addXTimes(10);
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(-1, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(11, 11));
    }

    @Test
    void removeThrowsErrorIfOutOfBounds(){
        addXTimes(10);
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(10));
    }

    private void addXTimes(int x) {
        for (int i = 0; i < x; i++) {
            linkedList.add(i);
        }
    }
}
