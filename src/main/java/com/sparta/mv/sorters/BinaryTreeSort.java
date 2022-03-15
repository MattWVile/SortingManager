package com.sparta.mv.sorters;

public class BinaryTreeSort implements Sorter{
    private final Node rootNode;
    private int counter = 0;

    private BinaryTreeSort(final int element) {
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

    public int[] sort(int[] numbers) {
        Node node = getRootElement();
        int[] arrayToSort = new int[counter];
        Node parent = node;
        int i = 0;
        while (i < counter - 1){
            if(!node.isLeftChildEmpty() && arrayToSort[i -1] != node.getValue()){
                parent = node;
                node = node.getLeftChild();
            } else if (node.isLeftChildEmpty() && arrayToSort[i -1] != node.getValue()){
                arrayToSort[i] = node.getValue();
                i ++;
                node = parent;
            } else if (!node.isRightChildEmpty() && arrayToSort[i -1] != node.getValue()){
                parent = node;
                node = node.getRightChild();
            } else if (node.isRightChildEmpty()&& arrayToSort[i -1] != node.getValue()){
                arrayToSort[i] = node.getValue();
                i ++;
                node = parent;
            } else{
                node = getRootElement();
            }
        }

        return arrayToSort;
    }
}