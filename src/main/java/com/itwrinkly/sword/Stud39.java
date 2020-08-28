package com.itwrinkly.sword;

/**
 * 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过了数组长度的一半，请找出这个数字。例如：输入一个长度为9的数组
 * {1,2,3,2,2,2,5,4,2} 输出为2
 */
public class Stud39 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,5,5,5,4,5};
        int last = moreThanHalfNumber(arr);
        System.out.println("last:" + last);
        //第二种方法
        last = part(arr, 0, arr.length - 1);
        System.out.println("part:" + arr[4]);
    }

    private static int part(int[] arr, int start, int end) {
        if (arr == null) return -1;
        int mid = partition(arr, start, end);
        while (mid != arr.length / 2) {
            if (mid < arr.length / 2) {
                mid = partition(arr, mid + 1, end);
            } else {
                mid = partition(arr, start, mid);
            }
        }
        return mid;
    }

    private static int partition(int[] arr, int start, int end) {
        int tmp = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= tmp) end--;
            arr[start] = arr[end];
            while (start < end && arr[start] <= tmp) start++;
            arr[end] = arr[start];
        }
        arr[start] = tmp;
        return start;
    }

    private static int moreThanHalfNumber(int[] arr) {
        if (arr == null) return -1;
        int last = arr[0]; int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (last == arr[i]) {
                count++;
            } else {
                if (--count == 0) {
                    last = arr[i];
                    count = 1;
                }
            }
        }

        return last;
    }
}
