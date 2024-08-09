package SortingAlgorithms;

import Main.List;
import Main.MyLinkedList;

public class MergeSort implements SortStrategy{
    @Override
    public void sort(List elements) {
        if (elements.size() < 2) {
            return;
        }

        int middle = elements.size() / 2;
        List left = new MyLinkedList();
        List right = new MyLinkedList();

        for (int i = 0; i < middle; i++) {
            left.add(elements.get(i));
        }
        for (int i = middle; i < elements.size(); i++) {
            right.add(elements.get(i));
        }

        sort(left);
        sort(right);

        merge(elements, left, right);
    }

    private void merge(List elements, List leftHalf, List rightHalf) {
        int leftIndex = 0, rightIndex = 0, k = 0;

        while (leftIndex < leftHalf.size() && rightIndex < rightHalf.size()) {
            if (leftHalf.get(leftIndex) <= rightHalf.get(rightIndex)) {
                elements.remove(k);
                elements.add(leftHalf.get(leftIndex), k);
                leftIndex++;
            } else {
                elements.remove(k);
                elements.add(rightHalf.get(rightIndex), k);
                rightIndex++;
            }
            k++;
        }

        while (leftIndex < leftHalf.size()) {
            elements.remove(k);
            elements.add(leftHalf.get(leftIndex), k);
            leftIndex++;
            k++;
        }

        while (rightIndex < rightHalf.size()) {
            elements.remove(k);
            elements.add(rightHalf.get(rightIndex), k);
            rightIndex++;
            k++;
        }
    }
}
