package Main;

public interface List {
    void add(int i);
    void add(int i, int index);
    int size();
    void remove(int index);
    int get(int index);

    static void handleOutOfBounds(int index, int size) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("[Index: "+index+", Range: "+(size - 1)+"]");
        }
    }
}

// abstract classes, like interfaces CANNOT be instantiated directly
// interfaces cannot provide an implementation for any of their methods
// abstract classes DO provide an implementation for at least 1 concrete method
// abstract classes DO NOT provide an implementation for "abstract" methods
//   ^ these are like interface methods, they force inheritors to implement these
//
//public abstract class ListTest {
//
//    private List list;
//
//    abstract void createList();
//
//    @BeforeEach
//    void setup() {
//        this.list = this.createList();
//    }
//
//    @Test
//    public void blah() {
//        // has an implementation
//    }
//}
//
//public class ArrayListTest extends ListTest {
//
//    @Override
//    void createList() {
//        return new ArrayList();
//    }
//}
