package Test;

import Main.List;
import Main.MyArrayList;
import Main.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    private List list;

    @BeforeEach
    void setup(){
        list = new MyArrayList();
    }

    @Test
    void newLinkHas0size() {
        assertEquals(0, list.size());
    }

    @Test
    void addsOneItem() {
        list.add(1);
        assertEquals(1, list.get(0));
    }

    @Test
    void addsTwoItems() {
        addXTimes(2);
        assertEquals(1, list.get(1));
    }

    @Test
    void addsThreeItems() {
        addXTimes(3);
        assertEquals(2, list.get(2));
    }

    @Test
    void addsToTheMiddle(){
        addXTimes(10);
        assertEquals(3, list.get(3));

        list.add(20, 3);
        assertEquals(20, list.get(3));
    }

    @Test
    void addsToBeginning1000Times(){
        for (int i = 0; i < 1000; i++) {
            list.add(i, 0);
        }

        var index = 0;
        for (int i = 999; i >= 0; i--) {
            assertEquals(i, list.get(index));
            index++;
        }
    }

    @Test
    void addsToEndWithIndex(){
        addXTimes(5);
        assertEquals(5, list.size());
        list.add(5, 5);
        assertEquals(5, list.get(5));
    }

    @Test
    void sizeIncreasesWhenAddingItemsToFront() {
        addXTimes(10);
        list.add(20, 0);
        assertEquals(11, list.size());
    }

    @Test
    void sizeIncreasesWhenAddingItemsToMiddle() {
        addXTimes(10);
        list.add(20, 5);
        assertEquals(11, list.size());
    }

    @Test
    void sizeIncreasesWhenAddingItemsToEnd() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
            assertEquals(i + 1, list.size());
        }
    }

    @Test
    void getReturnsFirstItem() {
        addXTimes(10);
        assertEquals(0, list.get(0));
    }

    @Test
    void getReturnsMiddleItem() {
        addXTimes(10);
        assertEquals(2, list.get(2));
    }

    @Test
    void getReturnsLastItem() {
        addXTimes(10);
        assertEquals(4, list.get(4));
    }

    @Test
    void removesFromFront() {
        addXTimes(5);
        list.remove(0);
        assertEquals(1, list.get(0));
    }

    @Test
    void removesFromMiddle() {
        addXTimes(10);
        assertEquals(3, list.get(3));
        list.remove(3);
        assertEquals(4, list.get(3));
    }

    @Test
    void removesFromBack() {
        addXTimes(10);
        assertEquals(9, list.get(9));
        list.remove(9);
        list.add(15);
        assertEquals(15, list.get(9));
    }

    @Test
    void getThrowsErrorIfOutOfBounds(){
        addXTimes(10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(10));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    void addThrowsErrorIfOutOfBounds(){
        addXTimes(10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(11, 11));
    }

    @Test
    void removeThrowsErrorIfOutOfBounds(){
        addXTimes(10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(10));
    }

    private void addXTimes(int x) {
        for (int i = 0; i < x; i++) {
            list.add(i);
        }
    }
}