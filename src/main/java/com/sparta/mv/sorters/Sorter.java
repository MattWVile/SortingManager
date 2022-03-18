package com.sparta.mv.sorters;

public interface Sorter {
    int[] sort(int[] numbers);

    default int[] rangeCheck(int[] numbers) {
        if (numbers.length > 1000) {
            int[] arr = new int[1];
            return arr;
        }
        return numbers;
    }
}
