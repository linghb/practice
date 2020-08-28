package com.itwrinkly.algorithm;

/**
 * 一个数组，要求删除相邻的重复节点，例如1，2，2，4，2，6，输出1，2，4，2，6
 */
public class DelAdjacentNumber {

    public static void main(String[] args) {
        //方法一：两次循环法
        //towLoopDel();

        //方法二：两次循环法
        doublePointDel();
    }

    private static void doublePointDel() {
        int[] arr = {1, 2, 2, 4, 2, 6};
        if (arr == null || arr.length == 0 )return;
        int left = 0; int right = 1;
        while (right < arr.length) {
            if (arr[left] != arr[right]) {
                left++;
                arr[left] = arr[right];
            }
            right++;
        }

        for (int i = 0; i <= left; i++) {
            System.out.println("arr:" + arr[i]);
        }
    }

    private static void towLoopDel() {
        int[] arr = {1, 2, 2, 4, 2, 6};
        int idx = 0;
        for (int i = 0; i < arr.length; ) {
            for ( int j = i + 1; j < arr.length; j++) {
                if (arr[i] != arr[j]) {
                    arr[idx++] = arr[i];
                    i = j;
                    if (j == arr.length - 1) {
                        arr[idx++] = arr[j];
                        i++;
                    }
                    break;
                }
            }
        }

        for (int i = 0; i < idx; i++) {
            System.out.println("arr:" + arr[i]);
        }
    }
}
