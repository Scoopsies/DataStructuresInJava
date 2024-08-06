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
        linkedList.add(0);
        linkedList.add(1);
        assertEquals(1, linkedList.get(1));
    }

    @Test
    void addsThreeItems() {
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        assertEquals(2, linkedList.get(2));
    }

    @Test
    void addsToTheMiddle(){
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        assertEquals(3, linkedList.get(3));

        linkedList.add(20, 3);
        assertEquals(20, linkedList.get(3));
    }

    @Test
    void addsToBeginning(){
        for (int i = 1; i < 6; i++) {
            linkedList.add(i);
        }
        assertEquals(1, linkedList.get(0));

        linkedList.add(0, 0);
        assertEquals(0, linkedList.get(0));
        assertEquals(1, linkedList.get(1));
        assertEquals(2, linkedList.get(2));
        assertEquals(3, linkedList.get(3));
    }

    @Test
    void sizeIncreasesWhenAddingItemsToEnd() {
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
            assertEquals(i + 1, linkedList.size());
        }
    }

    @Test
    void sizeIncreasesWhenAddingItemsToMiddle() {
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
        linkedList.add(20, 5);
        assertEquals(11, linkedList.size());
    }


    @Test
    void getReturnsFirstItem() {
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        assertEquals(0, linkedList.get(0));
    }

    @Test
    void getReturnsMiddleItem() {
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        assertEquals(2, linkedList.get(2));
    }

    @Test
    void getReturnsLastItem() {
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        assertEquals(4, linkedList.get(4));
    }
}
