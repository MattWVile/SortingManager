package com.sparta.mv;

import java.time.Duration;
import java.util.Arrays;
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
        System.out.println("Sorting this array: " + Arrays.toString(arrayToSort) + " Using the " + SortFactory.getSorter(choice).toString() + " method");
        long before = System.nanoTime();
        int[] sortedArray = SortFactory.getSorter(choice).sort(arrayToSort);
        long after = System.nanoTime();
        long timeTaken = after - before;
        System.out.println("Sorted array : " + Arrays.toString(sortedArray) + " This took: " + timeTaken + " Nano seconds." );



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
