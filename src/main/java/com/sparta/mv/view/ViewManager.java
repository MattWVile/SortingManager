package com.sparta.mv.view;

import com.sparta.mv.SortFactory;
import com.sparta.mv.Sorter;

public class ViewManager {
    public static Sorter sorterPicker(int choice){
        return SortFactory.getSorter(choice);
    }
}
