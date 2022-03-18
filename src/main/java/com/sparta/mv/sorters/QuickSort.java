package com.sparta.mv.sorters;

public class QuickSort implements Sorter{
    @Override
    public int[] sort(int[] numbers) {
        if (numbers.length>1000){
            int[] arr = new int[1];
            return arr;
        }
        return quickSort(numbers,0,numbers.length -1);
    }

    @Override
    public String toString(){
        return "Quick sort";
    }

    public int[] quickSort(int[] arr, int first, int last) {
        if (first < last) {
            int partitionIndex = partition(arr, first, last);

            quickSort(arr, first, partitionIndex-1);
            quickSort(arr, partitionIndex+1, last);
        }
        return arr;
    }
    private int partition(int arr[], int first, int last) {
        int pivot = arr[last];
        int num = (first-1);

        for (int i = first; i < last; i++) {
            if (arr[i] <= pivot) {
                num++;

                int swapTemp = arr[num];
                arr[num] = arr[i];
                arr[i] = swapTemp;
            }
        }

        int swapTemp = arr[num+1];
        arr[num+1] = arr[last];
        arr[last] = swapTemp;

        return num+1;
    }

}
