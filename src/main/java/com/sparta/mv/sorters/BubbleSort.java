package com.sparta.mv.sorters;

public class BubbleSort implements Sorter {
    @Override
    public int[] sort(int[] numbers) {
        boolean swapped = false;
        while (!swapped) {
            swapped = true;
            for (int count = 1; count < numbers.length; ++count) {
                if (numbers[count - 1] > numbers[count]) {
                    swap(numbers, count);
                    swapped = false;
                }
            }
        }
        return rangeCheck(numbers);

    }

    @Override
    public String toString() {
        return "Bubble sort";
    }

    private static void swap(int[] numbers, int count) {
        int placeHolder = numbers[count - 1];
        numbers[count - 1] = numbers[count];
        numbers[count] = placeHolder;
    }
}

