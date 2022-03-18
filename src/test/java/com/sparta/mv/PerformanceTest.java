package com.sparta.mv;

import com.sparta.mv.sorters.SortFactory;
import com.sparta.mv.sorters.Sorter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PerformanceTest {
    @Test
    @DisplayName("Time taken to sort")
    void timeTakenToSort() {
        int[] in = {7, 2, 3, 5, 74, 6, 8, 9, 4, 1,56,234,456,345,940,-344,-600,-900,-20,-234};
        int num = 1;
        int[] times = new int[3];
        String[] sortNames = new String[3];
        while (num <= 3) {
            Sorter sorter = SortFactory.getSorter(num);
            sortNames[num - 1] = sorter.toString();
            long timeStart = System.nanoTime();
            sorter.sort(in);
            long timeStop = System.nanoTime();
            long timeTaken = timeStop - timeStart;
            times[num - 1] = (int) timeTaken;
            num++;
        }
        int i = 0 ;
        while(i < sortNames.length){
            System.out.println(sortNames[i] + " took: " + times[i] + " Nanoseconds to complete.");
            i++;
        }

    }

}
