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
    void sizeIncreasesWhenAddingItems() {
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
            assertEquals(i + 1, linkedList.size());
        }
    }

    @Test
    void sizeDecreasesWhenAddingItems() {
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
    }

    @Test
    void getReturnsFirst() {
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        assertEquals(0, linkedList.get(0));
    }

    @Test
    void getReturnsMiddle() {
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        assertEquals(2, linkedList.get(2));
    }

    @Test
    void getReturnsLast() {
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        assertEquals(4, linkedList.get(4));
    }

}
