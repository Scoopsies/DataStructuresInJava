package SortingAlgorithms;

import Main.List;

public class BubbleSort implements SortStrategy{
    @Override
    public void sort(List list) {
        int n = list.size();
        boolean isSwapped;

        for (int i = 0; i < n - 1; i++) {
            isSwapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int highItem = list.get(j);
                    list.remove(j);
                    list.add(list.get(j), j);
                    list.remove(j + 1);
                    list.add(highItem, j + 1);

                    isSwapped = true;
                }
            }

            if (!isSwapped) break;
        }
    }
}
