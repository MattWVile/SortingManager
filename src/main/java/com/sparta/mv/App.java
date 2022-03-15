package com.sparta.mv;

import java.util.Random;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) {
        System.out.println("1.Bubble sort");
        Scanner input = new Scanner(System.in);
        System.out.print("Please choose a method to sort using: ");
        int choice = input.nextInt();
        System.out.print("Please state an array size: ");
        int arraySize = input.nextInt();
        int[] arrayToSort = arrayGenerator(arraySize);
        System.out.println("Sorting this array: " + arrayToSort.toString() + " Using the " + SortFactory.getSorter(choice)+ " method");
        int[] sortedArray = SortFactory.getSorter(choice).sort(arrayToSort);
        System.out.println("Sorted array : " + sortedArray.toString() + "This took: "  );



    }

    private static int[] arrayGenerator(int arraySize) {
        int[] arrayToSort = new int[arraySize];
        for (int i = 0; i < arraySize; i ++){
            int rand = new Random().nextInt(1000 + 1000) - 1000;
            arrayToSort[i] = rand;
        }
        return arrayToSort;
    }
}
