package com.sparta.mv;

import com.sparta.mv.sorters.SortFactory;
import com.sparta.mv.sorters.Sorter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class PerformanceTest {
    private static int sorterCount = 4;

    @Test
    @DisplayName("Time taken to sort")
    void timeTakenToSort() {
        int[] in = {7, 2, 3, 5, 74, 6, 8, 9, 4, 1,56,234,456,345,940,-344,-600,-900,-20,-234 };
        int num = 1;
        int[] times = new int[sorterCount];
        String[] sortNames = new String[sorterCount];
        for(int i = 0; i <= 10; i++) {
            while (num <= sorterCount) {
                Sorter sorter = SortFactory.getSorter(num);
                sortNames[num - 1] = sorter.toString();
                long timeStart = System.nanoTime();
                sorter.sort(in);
                long timeStop = System.nanoTime();
                long timeTaken = timeStop - timeStart;
                if (times[num -1] > (int) timeTaken || times[num -1] == 0){
                    times[num - 1] = (int) timeTaken;
                }
                num++;
            }
        }

        outputTimesWithNames(times, sortNames, "an array of size of 22.");

    }

    @Test
    @DisplayName("Time taken to sort large array")
    void timeTakenToSortLargeArray() {
        int[] in = new int[900];
        int j = 0;
        for (int element:in) {
            int rand = new Random().nextInt(1000 + 1000) - 1000;
            in[j] = rand;
            j++;
        }
        int num = 1;
        int[]out = in;
        Arrays.sort(out);
        int[] times = new int[sorterCount];
        String[] sortNames = new String[sorterCount];
        for(int i = 0; i <= 10; i++) {
            while (num <= sorterCount) {
                Sorter sorter = SortFactory.getSorter(num);
                sortNames[num - 1] = sorter.toString();
                long timeStart = System.nanoTime();
                sorter.sort(in);
                long timeStop = System.nanoTime();
                long timeTaken = timeStop - timeStart;
                if (times[num -1] > (int) timeTaken || times[num -1] == 0){
                    times[num - 1] = (int) timeTaken;
                }
                num++;
            }
        }

        outputTimesWithNames(times, sortNames, "an array of size of 900.");
    }

    private void outputTimesWithNames(int[] times, String[] sortNames, String arraySize) {
        System.out.println("-------------------");
        int i = 0 ;
        while(i < sortNames.length){
            System.out.println(sortNames[i] + " took: " + times[i] + " Nanoseconds to complete " + arraySize);
            i++;
        }
    }

}
