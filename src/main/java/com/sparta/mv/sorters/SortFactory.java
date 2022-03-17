package com.sparta.mv.sorters;

import com.sparta.mv.sorters.binarytree.BinaryTree;

public class SortFactory {
    public static Sorter getSorter(int choice) {
        switch(choice){
            case 1:
                return new BubbleSort();
            case 2:
                return new BinaryTreeSort();
            default:
                return null;
        }
    }
}
