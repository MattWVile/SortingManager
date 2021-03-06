package com.sparta.mv.sorters;

import com.sparta.mv.exceptions.SorterLoaderException;
import com.sparta.mv.sorters.binarytree.BinaryTree;

public class SortFactory {
    public static Sorter getSorter(int choice) {
        switch(choice){
            case 1:
                return new BubbleSort();
            case 2:
                return new BinaryTreeSort();
            case 3:
                return new QuickSort();
            case 4:
                return new InsertionSort();
            default:
                return new SorterLoaderException("Invalid sorter choice: " + choice);
        }
    }
}
