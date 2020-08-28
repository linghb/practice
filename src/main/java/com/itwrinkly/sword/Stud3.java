package com.itwrinkly.sword;


public class Stud3 {
    static int a[] = {2, 3, 1, 0, 2, 5, 3};
    static int b[] = {2, 3, 5, 4, 3, 2, 6, 7};
    public static void main(String[] args) {
        findDupNumber();
        System.out.println("findDupNumberAndNotModArray:" + findDupNumberAndNotModArray());
    }

    /**
     * 不修改数组找出数组中重复的数字:长度为n+1的数组里所有数字都在范围1 ~ n范围内
     */
    private static int findDupNumberAndNotModArray() {
        if (b == null || b.length < 2) return  -1;
        int start = 1;
        int end = b.length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = findCount(start, middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                }
            }
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    private static int findCount(int start, int end) {
        int count = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] >= start && b[i] <= end) {
                count++;
            }
        }
        return count;
    }

    /**
     * 找出数组中重复的数字:长度为n的数组里所有数字都在范围0 ~ n-1范围内
     */
    private static void findDupNumber() {
        for (int i = 0; i < a.length; i++) {
            while(a[i] != i) {
                if (a[i] == a[a[i]]) {
                    System.out.println("duplication:" + a[i]);
                    return;
                }
                swap(i, a[i]);
            }
        }
    }

    private static void swap(int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }
}
