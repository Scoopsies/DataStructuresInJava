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
        var nodeShiftingForward = getNode(index);
        var newNode = new Node(nodeShiftingForward.prev, i, nodeShiftingForward);
        nodeShiftingForward.prev = newNode;
        handlePrevNode(newNode, index);
        size++;
    }

    private void handlePrevNode(Node newNode, int index) {
        if (index == 0) {
            first = newNode;
        }
        else {
            var prevNode = getNode(index - 1);
            prevNode.next = newNode;
        }
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
        var node = getNode(index);
        return node.item;
    }

    private Node getNode(int index) {
        var result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }
}
