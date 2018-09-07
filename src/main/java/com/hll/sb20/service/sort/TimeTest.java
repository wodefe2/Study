package com.hll.sb20.service.sort;

import java.time.Instant;
import java.util.*;

/**
 * @Author helili
 * @Create_Date 2018/9/6
 */
public class TimeTest {
    private static final int SIZE = 10000;
    static final List<Integer> TEST_ARRAY = new ArrayList(SIZE);
    private static final List<Sortable> SORTABLE_LIST = new ArrayList<>();

    static {
        for (int i = 0; i < SIZE; i++) {
            TEST_ARRAY.add(i);
        }
        Collections.shuffle(TEST_ARRAY);
//        SORTABLE_LIST.add(new BubblingSort());
        SORTABLE_LIST.add(new SelectionSort());
        SORTABLE_LIST.add(new InsertSort());
        SORTABLE_LIST.add(new QuickSort());
        SORTABLE_LIST.add((list) -> {
            list.sort(Comparator.naturalOrder());
            return list;
        });
    }

    public static void testTime() {
        SORTABLE_LIST.forEach((sortable -> {
            long startTime = Instant.now().toEpochMilli();
            List<Integer> temp = new ArrayList<>(TEST_ARRAY);
            temp.addAll(TEST_ARRAY);
            sortable.sort(temp);
            long end = Instant.now().toEpochMilli();
            System.out.println(sortable.getClass().getSimpleName() + " costs " + (end - startTime) + "ms");
        }));
    }

    public static void main(String[] args) {
        testTime();
    }
}
