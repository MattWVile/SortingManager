package com.sparta.mv.sorters.binarytree;

import com.sparta.mv.exceptions.ChildNotFoundException;

public interface BinaryTreeMethods {
    BinaryTree.Node getRootElement();

    int getNumberOfElements();

    void addElement(int element);

    void addElements(final int[] elements);

    boolean findElement(int value);

    int getLeftChild(int element) throws ChildNotFoundException;

    int getRightChild(int element) throws ChildNotFoundException;

    int[] getSortedTreeAsc();

    int[] getSortedTreeDesc();
}

