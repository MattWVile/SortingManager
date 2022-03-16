package com.sparta.mv.view;

import com.sparta.mv.SortFactory;
import com.sparta.mv.sorters.BinaryTreeSort;
import com.sparta.mv.sorters.Sorter;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ViewManager {
    private static int rootNode = 0;
    private static Scanner input = new Scanner(System.in);

    public static void view(){
        int num = 1;
        displaySorters(num);
        Sorter sorter = sorterPicker();
        int length = arrayLength();
        int arrayToSort[] = new int[length];
        if (sorter instanceof BinaryTreeSort){
            int rootNode = rootNode();
            arrayToSort = arrayGeneratorWithRoot(length, rootNode );
        }else{
            arrayToSort = arrayGenerator(length);
        }
        System.out.println("Sorting this array: " + Arrays.toString(arrayToSort) + " Using the " + sorter.toString() + " method");
        long timeStart = System.nanoTime();
        int[] sortedArray = sorter.sort(arrayToSort);
        long timeStop = System.nanoTime();
        long timeTaken = timeStop - timeStart;
        System.out.println("Sorted array : " + Arrays.toString(sortedArray) + " This took: " + timeTaken + " Nano seconds.");
    }

    private static void displaySorters(int num) {
        while(num <= 2){
            System.out.println(num + ": " + SortFactory.getSorter(num, 0).toString());
            num++;
        }
    }

    private static Sorter sorterPicker(){
        System.out.print("Please choose a method to sort using: ");
        int choice = input.nextInt();
        return SortFactory.getSorter(choice, 0);


    }

    private static int[] arrayGenerator(int arraySize) {
        int[] arrayToSort = new int[arraySize];
        for (int i = 0; i < arraySize; i ++){
            int rand = new Random().nextInt(1000 + 1000) - 1000;
            arrayToSort[i] = rand;
        }
        return arrayToSort;
    }

    private static int[] arrayGeneratorWithRoot(int arraySize, int rootNode) {
        int[] arrayToSort = new int[arraySize];
        arrayToSort[0] = rootNode;
        for (int i = 1; i < arraySize; i ++){
            int rand = new Random().nextInt(1000 + 1000) - 1000;
            arrayToSort[i] = rand;
        }
        return arrayToSort;
    }

    private static int arrayLength(){
        System.out.print("Please state an array size: ");
        int length = input.nextInt();
        return length;
    }

    private static int rootNode(){
        System.out.print("Please state your root node: ");
        int rootNode = input.nextInt();
        return rootNode;
    }

}
