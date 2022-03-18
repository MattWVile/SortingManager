package com.sparta.mv.exceptions;

import com.sparta.mv.sorters.Sorter;

public class SorterLoaderException implements Sorter {
    public SorterLoaderException(String s) {

    }

    @Override
    public int[] sort(int[] numbers) {
        return new int[0];
    }
}
