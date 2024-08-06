package Main;

public class MyLinkedList implements List{

    public MyLinkedList() {}
    int size;
    Node first;
    Node last;

    private static class Node {
        Node prev;
        Node next;
        int item;

        Node(Node prev, int item, Node next){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }


    @Override
    public void add(int i) {
        if (first == null) {
            first = new Node(null, i, null);
            last = first;
        }
        else {
            Node newNode = new Node(last, i, null);
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public void add(int i, int index) {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public int get(int index) {
        if (index == 0){
            return first.item;
        }
        else {
            return last.item;
        }
    }
}
