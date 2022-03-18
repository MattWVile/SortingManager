package com.sparta.mv.sorters;

public class InsertionSort implements Sorter{
    @Override
    public int[] sort(int[] numbers) {

        int length = numbers.length;
        for (int i = 1; i < length; ++i) {
            int num = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > num) {
                numbers[j + 1] = numbers[j];
                j = j - 1;
            }
            numbers[j + 1] = num;
        }

        return rangeCheck(numbers);
    }
    @Override
    public String toString(){
        return "Insertion sort";
    }
}
