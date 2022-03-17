package com.sparta.mv;

import com.sparta.mv.sorters.SortFactory;
import com.sparta.mv.sorters.Sorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        }
    }

    @Test
    @DisplayName("Time taken to sort")
    void timeTakenToSort() {
        int[] in = {7, 2, 3, 5, 74, 6, 8, 9, 4, 1};
        int num = 1;
        int[] times = new int[2];
        while (num <= 2) {
            Sorter sorter = SortFactory.getSorter(num);
            long timeStart = System.nanoTime();
            sorter.sort(in);
            long timeStop = System.nanoTime();
            long timeTaken = timeStop - timeStart;
            times[num - 1] = (int) timeTaken;
            num++;
        }
        System.out.println(Arrays.toString(times));
    }
}
