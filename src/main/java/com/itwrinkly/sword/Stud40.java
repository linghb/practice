package com.itwrinkly.sword;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小的K个数
 * 题目：输入n个整数，找出其中最小的k个数，例如：4，5，1，6，2，7，3，8，最小的4个数字为：1，2，3，4
 */
public class Stud40 {

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            if (i < 4) {
                maxHeap.add(arr[i]);
            } else {
                int max = maxHeap.peek();
                if (max > arr[i]) {
                    maxHeap.remove();
                    maxHeap.add(arr[i]);
                }
            }

        }
        System.out.println("maxHeap:" + maxHeap);
    }
}
