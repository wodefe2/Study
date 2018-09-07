package com.hll.sb20.service.sort;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author helili
 * @Create_Date 2018/9/6
 */
public class BubblingSort implements Sortable {
    @Override
    public List<Integer> sort(List<Integer> source) {
        List<Integer> temp = new ArrayList<>(source);
        temp.addAll(source);

        for (int i = 0; i < temp.size() - 1; i++) {
            for (int j = i; j < temp.size() - 1; j++) {
                if (temp.get(j) > temp.get(j + 1)) {
                    swap(temp, j, j + 1);
                }
            }
        }
        return temp;
    }


    public static void main(String[] args) {
        BubblingSort bubblingSort = new BubblingSort();
        System.out.println(bubblingSort.sort(TimeTest.TEST_ARRAY));
    }
}
