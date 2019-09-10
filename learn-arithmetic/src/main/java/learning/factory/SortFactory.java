package learning.factory;

import learning.strategy.ISort;
import learning.strategy.impl.*;
import learning.type.SortType;

public class SortFactory {
    public static ISort createSort(SortType sortType) {
        ISort iSort = null;
        if (SortType.BUBBLING.equals(sortType)) {
            iSort = new BubblingSort();
        } else if (SortType.BETTER_BUBBLING.equals(sortType)) {
            iSort = new BetterBubblingSort();
        } else if (SortType.QUICK.equals(sortType)) {
            iSort = new QuickSort();
        } else if (SortType.INSERT.equals(sortType)) {
            iSort = new InsertSort();
        } else if (SortType.HILL.equals(sortType)) {
            iSort = new HillSort();
        } else if (SortType.SELECT.equals(sortType)) {
            iSort = new SelectSort();
        } else if (SortType.HEAP.equals(sortType)) {
            iSort = new HeapSort();
        }
        return iSort;
    }
}
