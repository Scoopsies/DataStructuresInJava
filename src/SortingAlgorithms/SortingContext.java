package SortingAlgorithms;

import Main.List;

public class SortingContext {
    final private SortStrategy sortStrategy;

    public SortingContext(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void sort(List list) {
        sortStrategy.sort(list);
    }

}
