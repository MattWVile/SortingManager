package com.sparta.mv;

import com.sparta.mv.sorters.SortFactory;
import com.sparta.mv.sorters.Sorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SorterTest {
    @Test
    @DisplayName("All Sorter methods should sort")
    void allSorterMethodsShouldSort() {
        int num = 1;
        int[] in = {7, 2, 3, 5, 74, 6, 8, 9, 4, 1};
        int[] out = {1, 2, 3, 4, 5, 6, 7, 8, 9, 74};
        while (num <= 2){
            Sorter sorter = SortFactory.getSorter(num, 1);
            num ++;
            Assertions.assertArrayEquals(out, sorter.sort(in));
        }
    }
}
