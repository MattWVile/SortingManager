package com.sparta.mv.sorters.binarytree;

import com.sparta.mv.sorters.Sorter;

import java.util.Arrays;

public class BinaryTreeSort implements Sorter {
    
    private final Node rootNode;
    private int counter = 0;

    public BinaryTreeSort(final int element) {
        rootNode = new Node(element);
    }
    private void addElements (final int[] elements){
        for (int element : elements){
            addNodeToTree(rootNode, element);
        }
    }

    private void addNodeToTree (Node node, int element){
        if (element <= node.getValue()){
            if(node.isLeftChildEmpty()){
                Node left = new Node(element);
                node.setLeftChild(left);
                counter ++;
            }else{
                addNodeToTree(node.getLeftChild(), element);
            }
        }else if(element > node.getValue()) {
            if(node.isRightChildEmpty()){
                Node right = new Node(element);
                node.setRightChild(right);
                counter ++;
            }else{
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }
    private int getLeftChild(int element)  {
        int leftChild = findNode(element).getLeftChild().getValue();
        return leftChild;
    }

    private int getRightChild(int element)  {
        int rightChild = findNode(element).getRightChild().getValue();
        return rightChild;
    }

    private Node findNode(int element){
        Node node = rootNode;
        while(node != null){
            if(element == node.getValue()) {
                return node;
            }
            if (element < node.getValue()){
                node = node.getLeftChild();
            } else{
                node = node.getRightChild();
            }
        }
        return null;
    }

    private Node getRootElement() {
        return this.rootNode;
    }

    private static boolean check(int[] arr, int toCheckValue) {
        Arrays.sort(arr);
        int res = Arrays.binarySearch(arr, toCheckValue);
        boolean test = res > 0 ? true : false;
        return test;
    }

    @Override
    public int[] sort(int[] numbers) {
        Node node = getRootElement();
        addElements(numbers);
        int[] arrayToSort = new int[numbers.length];
        Node parent = node;
        int i = 0;
        while (i == 0 ) {
            if (!node.isLeftChildEmpty()) {
                parent = node;
                node = node.getLeftChild();
            } else if (node.isLeftChildEmpty()) {
                arrayToSort[i] = node.getValue();
                i++;
                if(!node.isRightChildEmpty()){
                    parent = node;
                    node = node.getRightChild();
                }else{
                    node = parent;
                }
            }
        }
        while (i < counter - 1){
            if(!node.isLeftChildEmpty() && check(arrayToSort, node.getLeftChild().getValue())){
                parent = node;
                node = node.getLeftChild();
            } else if (node.isLeftChildEmpty()){
                if(!check(arrayToSort, node.getValue())){
                    arrayToSort[i] = node.getValue();
                    i ++;
                    node = parent;
                }else if(node.isRightChildEmpty()){
                    node = parent;
                } else if (!node.isRightChildEmpty()){
                    parent = node;
                    node = node.getRightChild();
                }
            } else if (!node.isRightChildEmpty()){
                parent = node;
                node = node.getRightChild();
            } else if (node.isRightChildEmpty()&& !check(arrayToSort, node.getValue())){
                arrayToSort[i] = node.getValue();
                i ++;
                node = parent;
            } else{
                node = getRootElement();
            }
        }

        return arrayToSort;
    }

    @Override
    public String toString() {
        return "Binary tree sort";
    }
    public class Node {

        private final int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public boolean isLeftChildEmpty(){
            if (leftChild == null){
                return true;
            }else {
                return false;
            }
        }
        public boolean isRightChildEmpty(){
            if (rightChild == null){
                return true;
            }else {
                return false;
            }
        }

    }


}
