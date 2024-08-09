package Main;

public class MyLinkedList implements List{
    int size;
    Node first;
    Node last;

    public MyLinkedList() {}

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
            addFirst(i);
        } else {
            addLast(i);
        }
        size++;
    }

    @Override
    public void add(int i, int index) {
        List.handleOutOfBounds(index, size + 1);
        if (index == 0) {
            addFirst(i);
        } else if (index == size) {
            addLast(i);
        } else {
            addNth(i, index);
        }
        size++;
    }

    private void addFirst(int i) {
        var nodeShiftingForward = first;
        var newNode = new Node(null, i, nodeShiftingForward);
        first = newNode;
        if (nodeShiftingForward != null) {
            nodeShiftingForward.prev = newNode;
        }
        if (last == null) {
            last = first;
        }
    }

    private void addLast(int i) {
        Node newNode = new Node(last, i, null);
        last.next = newNode;
        last = newNode;
    }

    private void addNth(int i, int index) {
        var nodeShiftingForward = getNode(index);
        var prevNode = nodeShiftingForward.prev;
        var newNode = new Node(prevNode, i, nodeShiftingForward);
        nodeShiftingForward.prev = newNode;
        prevNode.next = newNode;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        List.handleOutOfBounds(index, size);
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
        List.handleOutOfBounds(index, size);
        var node = getNode(index);
        return node.item;
    }

    @Override
    public List createList() {
        return new MyLinkedList();
    }

    private Node getNode(int index) {
        var result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }
}
