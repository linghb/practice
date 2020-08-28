package com.itwrinkly.algorithm;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {9,8,3,7,6,5,4,3,2,1};
        quickSort(array, 0, array.length - 1);
        Arrays.stream(array).forEach(e -> System.out.println(e));
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pos = partition(array, low, high);
            quickSort(array, low, pos - 1);
            quickSort(array, pos + 1, high);
        }

//        尾递归优化：
//        while (low < high) {
//            int pos = partition(array, low, high);
//            quickSort(array, low, pos - 1);
//            low = pos + 1;
//        }
    }

    private static int partition(int[] array, int low, int high) {
        int tmp = array[low];
        int left = low;
        while (low < high) {
            while (low < high && array[high] >= tmp) high--;
            array[low] = array[high];
            while (low < high && array[low] <= tmp) low++;
            array[high] = array[low];
//            if (low < high) {
//                swapInt(array, low, high);
//            }
        }
//        array[left] = array[low];
        array[low] = tmp;
        return low;
    }

    private static void swapInt(int[] array, int low, int high) {
        array[low] = array[low] ^ array[high];
        array[high] = array[low] ^ array[high];
        array[low] = array[low] ^ array[high];
    }
}
