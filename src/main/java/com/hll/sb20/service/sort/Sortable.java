package com.hll.sb20.service.sort;

import java.util.List;

/**
 * @Author helili
 * @Create_Date 2018/9/6
 */
public interface Sortable {
    /**
     * 排序
     * @param source
     * @return
     */
    List<Integer> sort(List<Integer> source);

    default void swap(List<Integer> source, int i, int j) {
        Integer a = source.get(i);
        Integer b = source.get(j);
        source.set(i, b);
        source.set(j, a);
    }

}
