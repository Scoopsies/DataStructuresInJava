package Test;

import Main.MyLinkedList;
import org.junit.jupiter.api.*;

public class MyLinkedListTest extends ListTest{

    @Override
    @BeforeEach
    void setup() {
        list = new MyLinkedList();
    }
}
