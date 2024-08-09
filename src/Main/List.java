package Main;

public interface List {
    void add(int i);
    void add(int i, int index);
    int size();
    void remove(int index);
    int get(int index);
    List createList();

    static void handleOutOfBounds(int index, int size) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("[Index: "+index+", Range: "+(size - 1)+"]");
        }
    }
}