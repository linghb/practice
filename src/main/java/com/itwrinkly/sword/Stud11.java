package com.itwrinkly.sword;

/**
 * 旋转数组的最小数字
 * 如：数组{3,4,5,1,2} 为 {1,2,3,4,5}的旋转数组
 * 特例：数组{1,0,1,1,1}、{1,1,1,0,1} 都为{0,1,1,1,1}的旋转数组
 */
public class Stud11 {
    public static void main(String[] args) {
        int[] arr1 = {6,7,3,4,5};
        int[] arr2 = {1,0,1,1,1};
        System.out.println(findMin(arr1));
        System.out.println(findMin(arr2));
    }

    private static int findMin(int[] arr) {
        if (arr == null || arr.length <= 0) throw new RuntimeException("invalid array");
        if (arr.length == 1) return arr[0];
        int index1 = 0;
        int index2 = arr.length - 1;
        int indexMid = index1;
        while (arr[index1] >= arr[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) >>> 1;
            if (arr[indexMid] == arr[index1] && arr[indexMid] == arr[index2]) {
                return minOrder(arr, index1, index2);
            }
            if (arr[indexMid] >= arr[index1]) {
                index1 = indexMid;
            } else if (arr[indexMid] <= arr[index2]) {
                index2 = indexMid;
            }
        }


        return arr[indexMid];
    }

    private static int minOrder(int[] arr, int index1, int index2) {
        int result = arr[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if (result > arr[i]) {
                result = arr[i];
            }
        }
        return result;
    }
}
