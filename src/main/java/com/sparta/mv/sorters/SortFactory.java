package com.sparta.mv.sorters;

import com.sparta.mv.sorters.binarytree.BinaryTreeSort;

public class SortFactory {
    public static Sorter getSorter(int choice, int rootNode) {
        switch(choice){
            case 1:
                return new BubbleSort();
            case 2:
                return new BinaryTreeSort(rootNode);
            default:
                return null;
        }
    }
}
