package com.sparta.mv;

import com.sparta.mv.sorters.BubbleSort;
import com.sparta.mv.sorters.Sorter;

public class SortFactory {
    public static Sorter getSorter(int choice) {
        switch(choice){
            case 1:
                return new BubbleSort();

            default:
                return null;
        }
    }
}
