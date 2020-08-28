package com.itwrinkly.algorithm;

public class TowArrayMatch {

    public static void main(String[] args) {
        int[] arr1 = {3, 2, 7, 21, 9, 3, 1, 7, 8, 3};
        int[] arr2 = {3, 1, 5};
        int match = matchArr(arr1, arr2);
        System.out.println("match:" + match);

    }

    private static int matchArr(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0) return -1;
        int point1 = 0; int point2 = 0;
        while (point1 < arr1.length && point2 < arr2.length) {
            if (arr1[point1] == arr2[point2]) {
                point1++;
                point2++;
            } else {
                point1++;
                point2 = 0;
            }
        }

        if (point2 != arr2.length) return -1;
        return 1;
    }
}
