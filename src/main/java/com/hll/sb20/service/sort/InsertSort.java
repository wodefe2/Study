package com.hll.sb20.service.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author helili
 * @Create_Date 2018/9/6
 */
public class InsertSort implements Sortable {
    @Override
    public List<Integer> sort(List<Integer> source) {
        List<Integer> result = new ArrayList<>(source.size());
        result.add(source.get(0));
        for (int i = 1; i < source.size(); i++) {
            Integer currentSource = source.get(i);
            for (int j = result.size() - 1; ; j--) {
                if (j == -1) {
                    result.add(0, currentSource);
                    break;
                }
                if (currentSource > result.get(j)) {
                    result.add(j + 1, currentSource);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new InsertSort().sort(TimeTest.TEST_ARRAY));
    }
}
