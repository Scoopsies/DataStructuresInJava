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
}
