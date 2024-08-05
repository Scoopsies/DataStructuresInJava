package Test;

import Main.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    private MyArrayList arrayList;

    @BeforeEach
    void setup() {
        arrayList = new MyArrayList();
    }

    @Test
    void newArrayHas0size(){
        assertEquals(0, arrayList.size());
    }

    @Test
    void sizeWith1ItemIs1(){
        arrayList.add(0);
        assertEquals(1, arrayList.size());
    }

    @Test
    void getRetrievesItemAtIndex0(){
        arrayList.add(0);
        assertEquals(0, arrayList.get(0));
    }

    @Test
    void getRetrievesItemAtIndex1(){
        arrayList.add(0);
        arrayList.add(1);
        assertEquals(1, arrayList.get(1));
    }

    @Test
    void getThrowsErrorIfOutOfBounds(){
        arrayList.add(0);
        arrayList.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(-1));
    }

    @Test
    void removeThrowsErrorIfOutOfBounds(){
        arrayList.add(0);
        arrayList.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(2));
    }

    @Test
    void addThrowsErrorIfOutOfBounds(){
        arrayList.add(0);
        arrayList.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.add(0, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.add(0, 3));
    }

    @Test
    void addAddsItemsToBackOfArray(){
        for (int i = 0; i < 12; i++) {
            arrayList.add(i);
            assertEquals(i, arrayList.get(i));
        }
    }

    @Test
    void addWithIndex0addsItemsToFrontOfArray(){
        for (int i = 0; i < 12; i++) {
            arrayList.add(i, 0);
        }

        var reverseCounter = 11;

        for (int i = 0; i < 12; i++) {
            assertEquals(reverseCounter, arrayList.get(i));
            reverseCounter--;
        }
    }

    @Test
    void addsToMiddleOfArray(){
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(2, 2);

        for (int i = 0; i < 5; i++) {
            assertEquals(i, arrayList.get(i));
        }
    }

    @Test
    void isAbleToAdd1000ItemsToEnd(){
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
            assertEquals(i + 1, arrayList.size());
        }

        for (int i = 0; i < 1000; i++) {
            assertEquals(i, arrayList.get(i));
        }
    }

    @Test
    void isAbleToAdd1000ItemsToMiddle(){
        for (int i = 0; i < 1000; i++) {
            int middle = (int)(Math.ceil((double) arrayList.size() / 2));
            arrayList.add(i, middle);
        }
        assertEquals(1000, arrayList.size());
        assertEquals(999, arrayList.get(500));
    }

    @Test
    void isAbleToAdd1000ItemsToBeginning(){
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i, 0);
        }
        assertEquals(1000, arrayList.size());
        assertEquals(999, arrayList.get(0));
        assertEquals(0, arrayList.get(999));
    }

    @Test
    void removeFirstItemFromArray(){
        for (int i = 0; i < 4; i++) {
            arrayList.add(i);
        }
        arrayList.remove(0);
        assertEquals(1, arrayList.get(0));
        assertEquals(2, arrayList.get(1));
        assertEquals(3, arrayList.get(2));
        assertEquals(3, arrayList.size());
    }

    @Test
    void removesMiddleItemFromArray(){
        for (int i = 0; i < 5; i++) {
            arrayList.add(i);
        }
        arrayList.remove(2);
        assertEquals(0, arrayList.get(0));
        assertEquals(1, arrayList.get(1));
        assertEquals(3, arrayList.get(2));
        assertEquals(4, arrayList.get(3));
        assertEquals(4, arrayList.size());
    }
}