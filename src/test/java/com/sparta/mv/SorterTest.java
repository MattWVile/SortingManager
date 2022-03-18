package com.sparta.mv;

import com.sparta.mv.sorters.SortFactory;
import com.sparta.mv.sorters.Sorter;
import com.sparta.mv.view.ViewManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorterTest {
    private static int sorterCount = 4;
    @Test
    @DisplayName("All Sorter methods should sort with an odd amount in array")
    void allSorterMethodsShouldSortWithOddAmountInArray() {
        int num = 1;
        int[] in = {7, 2, 3, 5, 74, 6, 8, 9, 4, 1, -100};
        int[] out = {-100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 74};
        sortTest(sorterCount, in, out, " sorted successfully with an odd sized array.");
    }

    @Test
    @DisplayName("All sorter methods should sort with duplicates")
    void allSorterMethodsShouldSortWithDuplicates() {
        int num = 1;
        int[] in = {7, 2, 3, 5, 74, 6, 8, 9, 4, 1, -100 ,7 ,7 , 7};
        int[] out = {-100, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8, 9, 74};
        sortTest(sorterCount, in, out, " sorted successfully with duplicates.");
    }

    @Test
    @DisplayName("Array shouldn't be more than 1000 ")
    void arrayShouldNotBeMoreThanOneThousand() {
        int[] in = new int[1001];
        int[] out = new int[1];
        sortTest(sorterCount,in, out, " will not take more than 1000.");
    }

    @Test
    @DisplayName("No elements in a large array should be lost in sorting")
    void noElementsInALargeArrayShouldBeLostInSorting() {
        int[] in = new int[999];
        int i = 0;
        for (int element:in) {
            int rand = new Random().nextInt(1000 + 1000) - 1000;
            in[i] = rand;
            i++;
        }
        int[]out = in;
        Arrays.sort(out);
        sortTest(sorterCount, in, out, " sorted successfully with many elements.");
    }

    @Test
    @DisplayName("Sort factory should return the correct sorter")
    void sortFactoryShouldReturnTheCorrectSorter() {
        System.out.println("----------");
        String[] sortingNames = {"Bubble sort", "Binary tree sort", "Quick sort"};
        int num = 0;
        for(String name : sortingNames){
            assertEquals(sortingNames[num],SortFactory.getSorter(num + 1).toString());
            System.out.println("Inputting " + (num+1) + " returns: "+ SortFactory.getSorter(num + 1).toString());
            num++;
        }
    }

    @Test
    @DisplayName("Returns array with only one value")
    void returnsArrayWithOnlyOneValue() {
        int[] in = {1};
        int[] out = {1};
        sortTest(sorterCount,in ,out ," successfully returns an array with only one int");
    }

    @Test
    @DisplayName("Sorts an already sorted array")
    void sortsAnAlreadySortedArray() {
        int[] in = {-100, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8, 9, 74};
        int[] out = {-100, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8, 9, 74};
        sortTest(sorterCount, in, out , " sorts an already sorted array");
    }

    private void sortTest(int sorterCount, int[] in, int[] out, String message) {
        System.out.println("----------");
        int num = 1;
        while (num <= sorterCount){
            Sorter sorter = SortFactory.getSorter(num);
            num++;
            Assertions.assertArrayEquals(out, sorter.sort(in));
            System.out.println(sorter.toString() + message);
        }
    }
}
