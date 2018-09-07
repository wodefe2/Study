package com.hll.sb20.service.sort;

import java.util.List;

/**
 * @Author helili
 * @Create_Date 2018/9/6
 */
public class SelectionSort implements Sortable {
    @Override
    public List<Integer> sort(List<Integer> source) {
        for (int i = 0; i < source.size(); i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = i; j < source.size(); j++) {
                Integer currentJ = source.get(j);
                if(currentJ < min){
                    min = currentJ;
                    minIndex = j;
                }
            }
            swap(source, minIndex, i);
        }
        return source;
    }

    public static void main(String[] args) {
        Sortable sortable = new SelectionSort();
        System.out.println(sortable.sort(TimeTest.TEST_ARRAY));
    }
}
