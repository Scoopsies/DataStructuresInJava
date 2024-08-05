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
    }

    @Test
    void addAddsItemsToBackOfArray(){
        arrayList.add(0);
        assertEquals(0, arrayList.get(0));
        arrayList.add(1);
        assertEquals(1, arrayList.get(1));
    }

    @Test
    void addWithIndex0addsItemsToFrontOfArray(){
        arrayList.add(0);
        arrayList.add(10, 0);
        assertEquals(10, arrayList.get(0));
    }

    @Test
    void addWithIndex2addsItemsToIndex2OfArray(){
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(2, 2);
        assertEquals(2, arrayList.get(2));
        assertEquals(0, arrayList.get(0));
    }

    @Test
    void isAbleToAdd1000ItemsToEnd(){
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
        }
        assertEquals(1000, arrayList.size());
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
    void remove0RemovesFirstItemFromArray(){
        arrayList.add(0);
        arrayList.remove(0);
        assertEquals(0, arrayList.size());
    }

    @Test
    void remove1RemovesSecondItemFromArray(){
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.remove(1);
        assertEquals(2, arrayList.size());
        assertEquals(2, arrayList.get(1));
    }
}