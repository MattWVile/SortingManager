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
    @Test
    @DisplayName("All Sorter methods should sort")
    void allSorterMethodsShouldSort() {
        int num = 1;
        int[] in = {7, 2, 3, 5, 74, 6, 8, 9, 4, 1};
        int[] out = {1, 2, 3, 4, 5, 6, 7, 8, 9, 74};
        while (num <= 2){
            Sorter sorter = SortFactory.getSorter(num);
            num ++;
            Assertions.assertArrayEquals(out, sorter.sort(in));
            System.out.println(sorter.toString() + " sorted successfully.");
        }
        System.out.println("----------");
    }

    @Test
    @DisplayName("Array shouldnt be more than 1000 ")
    void arrayShouldntBeMoreThanOneThousand() {
        int[] in = new int[1001];
        int[] out = new int[1];
        int num = 1;
        while (num <= 2){
            Sorter sorter = SortFactory.getSorter(num);
            num ++;
            Assertions.assertArrayEquals(out, sorter.sort(in));
            System.out.println(sorter.toString() + " doesn't take 1000 or more");
        }
        System.out.println("----------");
    }

    @Test
    @DisplayName("No elements in a large array should be lost in sorting")
    void noElementsInALargeArrayShouldBeLostInSorting() {
        int num = 1;
        int[] in = new int[999];
        int i = 0;
        for (int element:in) {
            int rand = new Random().nextInt(1000 + 1000) - 1000;
            in[i] = rand;
            i++;
        }
        int[]out = in;
        Arrays.sort(out);
        while (num <= 2){
            Sorter sorter = SortFactory.getSorter(num);
            num ++;

            Assertions.assertArrayEquals(out, sorter.sort(in));
            System.out.println(sorter.toString() + " sorted successfully with many elements.");
        }
        System.out.println("----------");
    }

    @Test
    @DisplayName("Sort factory should return the correct sorter")
    void sortFactoryShouldReturnTheCorrectSorter() {
        String[] sortingNames = {"Bubble sort", "Binary tree sort"};
        int num = 0;
        for(String name : sortingNames){
            Assertions.assertEquals(sortingNames[num],SortFactory.getSorter(num + 1).toString());
            System.out.println("Inputting " + (num+1) + " returns: "+ SortFactory.getSorter(num + 1).toString());
            num++;
        }
        System.out.println("----------");
    }
}
