package com.sparta.mv.sorters.binarytree;

import com.sparta.mv.exceptions.ChildNotFoundException;

import java.util.logging.Level;

public class BinaryTree implements BinaryTreeMethods {

    private final Node rootNode;
    private int counter = 0;
    private int[] sorted = new int[counter];


    @Override
    public int getNumberOfElements(){
        return counter;
    }

    @Override
    public void addElement(final int element){
        addNodeToTree(rootNode, element);
    }

    public BinaryTree(final int element) {
        rootNode = new Node(element);
        counter ++;
    }
    @Override
    public void addElements(final int[] elements){
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
    @Override
    public int getLeftChild(int element) throws ChildNotFoundException{
        if(findNode(element).isLeftChildEmpty()){
            new ChildNotFoundException();
        }
        int leftChild = findNode(element).getLeftChild().getValue();
        return leftChild;
    }
    @Override
    public int getRightChild(int element)  {
        if(findNode(element).isRightChildEmpty()){
            new ChildNotFoundException();
        }
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
    @Override
    public boolean findElement(final int value){
        Node node = findNode(value);
        if (node != null){
            return true;
        }
        return false;
    }

    public Node getRootElement() {
        return this.rootNode;
    }

    @Override
    public int[] getSortedTreeAsc(){
        sorted = new int[counter];
        counter = 0;
        sortTreeAsc(rootNode);
        return sorted;
    }
    public void sortTreeAsc(Node node) {
        if(!node.isLeftChildEmpty()){
            sortTreeAsc(node.getLeftChild());
        }
        sorted[counter] = node.getValue();
        counter++;
        if(!node.isRightChildEmpty()){
            sortTreeAsc(node.getRightChild());
        }
    }
    @Override
    public int[] getSortedTreeDesc(){
        sorted = new int[counter];
        counter = 0;
        sortTreeDesc(rootNode);
        return sorted;

    }
    public void sortTreeDesc(Node node) {
        if(!node.isRightChildEmpty()){
            sortTreeDesc(node.getRightChild());
        }
        sorted[counter] = node.getValue();
        counter++;
        if(!node.isLeftChildEmpty()){
            sortTreeDesc(node.getLeftChild());
        }
    }

    public class Node {

        private final int value;
        public Node leftChild;
        public Node rightChild;

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
