package com.sparta.mv.sorters;

import com.sparta.mv.sorters.binarytree.BinaryTree;

public class BinaryTreeSort implements Sorter {
    @Override
    public int[] sort(int[] numbers) {
        BinaryTree tree = new BinaryTree(numbers[0]);
        int[] rootRemovedArray = rootRemover(numbers);
        tree.addElements(rootRemovedArray);
        int[] sorted = tree.getSortedTreeAsc();
        return sorted;
    }

    private int[] rootRemover(int[] numbers) {
        int[] arr = new int[numbers.length - 1];
        for (int i = 1; i < numbers.length; i++){
            arr[i-1] = numbers[i];
        }
        return arr;
    }

    @Override
    public String toString() {
        return "Binary tree sort";
    }
}

