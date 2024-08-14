package SortingAlgorithms;

import Main.List;

public class MergeSort implements SortStrategy{
    @Override
    public void sort(List list) {
        if (list.size() < 2) {
            return;
        }

        int middle = list.size() / 2;
        List left = list.createList();
        List right = list.createList();

        for (int i = 0; i < middle; i++) {
            left.add(list.get(i));
        }

        for (int i = middle; i < list.size(); i++) {
            right.add(list.get(i));
        }

        sort(left);
        sort(right);
        merge(list, left, right);
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
