package com.sparta.mv;

import com.sparta.mv.sorters.BubbleSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BubbleSortTest {

    @Test
    @DisplayName("Bubble sort sorts duplicates")
    void bubbleSortShouldSortWithDuplicates() {
        int[] in = {6, 5, 3, 6, 74, 6, 8, 9, 4, 4, 1};
        int[] out = {1, 3, 4, 4, 5, 6, 6, 6, 8, 9, 74};
        BubbleSort bubbleSort = new BubbleSort();
        Assertions.assertArrayEquals(out, bubbleSort.sort(in));
    }
}
