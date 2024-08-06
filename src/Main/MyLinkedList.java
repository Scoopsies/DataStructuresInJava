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
        handleOutOfBounds(index, size + 1);
        var nodeShiftingForward = getNode(index);
        if (index == 0) {
            var newNode = new Node(null, i, nodeShiftingForward);
            newNode.next = nodeShiftingForward;
            first = newNode;
        }
        else {
            var newNode = new Node(nodeShiftingForward.prev, i, nodeShiftingForward);
            nodeShiftingForward.prev = newNode;
            var prevNode = getNode(index - 1);
            prevNode.next = newNode;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            removeNth(index);
        }
        size--;
    }

    private void removeNth(int index) {
        handleOutOfBounds(index, size);
        var node = getNode(index);
        var prevNode = node.prev;
        var nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void removeLast() {
        var lastNode = last;
        last = lastNode.prev;
        last.next = null;
    }

    private void removeFirst() {
        var firstNode = first;
        first = firstNode.next;
        first.prev = null;
    }

    @Override
    public int get(int index) {
        handleOutOfBounds(index, size);
        var node = getNode(index);
        return node.item;
    }

    private void handleOutOfBounds(int index, int size) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("[Index: "+index+", Range: "+(size - 1)+"]");
        }
    }

    private Node getNode(int index) {
        var result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }
}
