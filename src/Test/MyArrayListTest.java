package Test;

import Main.MyArrayList;
import org.junit.jupiter.api.BeforeEach;

class MyArrayListTest extends ListTest {

    @Override
    @BeforeEach
    void setup() {
        list = new MyArrayList();
    }
}