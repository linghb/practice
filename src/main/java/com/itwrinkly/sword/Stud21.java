package com.itwrinkly.sword;

/**
 * 设计一个时间复杂度为O(n)的函数：调整数组顺序使得奇数位于偶数前
 */
public class Stud21 {

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        oddEven(data);
//        for (int i = 0; i < data.length; i++) {
//            System.out.println(data[i]);
//        }
    }

    private static void oddEven(int[] data) {
        if (data == null || data.length <= 1) return;
        int first = 0;
        int second = data.length - 1;
        while (first < second) {
            while (first < second && (data[first] & 0x01) != 0) {
                first++;
            }

            while (first < second && (data[second] & 0x01) == 0) {
                second--;
            }

            if (first < second) {
                swap(data, first, second);
            }
        }

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    private static void swap(int[] data, int first, int second) {
        data[first] = data[first] ^ data[second];
        data[second] = data[first] ^ data[second];
        data[first] = data[first] ^ data[second];
    }
}
