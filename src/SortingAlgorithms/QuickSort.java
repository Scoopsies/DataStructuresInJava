package SortingAlgorithms;

import Main.List;

public class QuickSort implements SortStrategy{

    public void sort(List list) {
        quickSort(list, 0, list.size() - 1);
    }

    private void quickSort(List list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    private int partition(List list, int low, int high) {
        int pivot = list.get(high);
        int lowIndex = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j) <= pivot) {
                lowIndex++;
                swap(list, lowIndex, j);
            }
        }

        swap(list, lowIndex + 1, high);

        return lowIndex + 1;
    }

    private void swap(List list, int i, int j) {
        if (i == j) return;
        int tempI = list.get(i);
        int tempJ = list.get(j);
        list.remove(j);
        list.remove(i);
        list.add(tempJ, i);
        list.add(tempI, j);
    }
}
