package com.sparta.mv;

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
