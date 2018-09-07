package com.hll.sb20.service.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author helili
 * @Create_Date 2018/9/6
 */
public class QuickSort implements Sortable {
    @Override
    public List<Integer> sort(List<Integer> source) {
        quickSort(source, 0, source.size() - 2
                , choosePivot(source, 0, source.size() - 1));
        return source;
    }

    private void quickSort(List<Integer> source, int start, int end, int pivot) {
        int left = start;//0
        int right = end;//3
        //pivot 4
        if (left > right || right < 0) {
            return;
        }
//        System.out.println("source : " + source + "start : " + start + " end: " + end + " pivot: " + pivot);
        Integer pivotValue = source.get(pivot);
        Integer leftValue = source.get(left);
        Integer rightValue = source.get(right);
        int newPivot;
        while (true) {
            boolean moveToPivot = false;
            leftValue = source.get(left);
            while (leftValue < pivotValue) {
                left++;
                leftValue = source.get(left);
                if (left == pivot) {
                    moveToPivot = true;
                    break;
                }
            }
            if (moveToPivot) {
                newPivot = left;
                break;
            }
            if (left == right) {
                swap(source, left, pivot);
                newPivot = left;
                break;
            }
            boolean isRightLT0 = false;
            rightValue = source.get(right);
            while (rightValue > pivotValue) {
                if (right - 1 < 0) {
                    isRightLT0 = true;
                    break;
                }
                right--;
                rightValue = source.get(right);
                if (right == left) {
                    break;
                }
            }
            if (isRightLT0 || right == left) {
                swap(source, left, pivot);
                newPivot = left;
                break;
            }
            swap(source, left, right);
            left++;
        }
        quickSort(source, start, newPivot - 2, newPivot - 1);
        quickSort(source, newPivot + 1, pivot - 1, pivot);
    }

    /**
     * 选择主元
     *
     * @param source
     * @param start
     * @param end
     * @return 返回主元所在的index
     */
    protected int choosePivot(List<Integer> source, int start, int end) {
        return end;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(0);
        System.out.println(new QuickSort().sort(TimeTest.TEST_ARRAY));
//        System.out.println(new QuickSort().sort(list));
    }
}
