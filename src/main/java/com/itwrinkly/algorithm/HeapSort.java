package com.itwrinkly.algorithm;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = {9,8,3,7,6,5,4,3,2,1};
//        heapSort(array);
//        Arrays.stream(array).forEach(e -> System.out.println(e));

        int[] a = insertHeap(array, 10);
        heapSort(a);
        Arrays.stream(a).forEach(e -> System.out.println(e));


    }

    private static void heapSort(int[] array) {
        if (array == null || array.length < 2) return;
        int len = array.length;
        //构建大堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            //从第一个非叶子节点从下至上，从左至右调整
            //adjustHeap(array, i, len);
            adjustMinHeap(array, i, len);
        }

        for (int i = len - 1; i > 0; i--) {
            swapVal(array, 0, i); // 将堆顶元素与末尾元素进行交换
            //adjustHeap(array, 0, i); // 重新对堆进行调整
            adjustMinHeap(array, 0, i); // 重新对堆进行调整
        }
    }

    private static void swapVal(int[] array, int one, int two) {
        array[one] = array[one] ^ array[two];
        array[two] = array[one] ^ array[two];
        array[one] = array[one] ^ array[two];
    }

    private static void adjustHeap(int[] array, int i, int len) {
        int tmp = array[i]; // 取出当前元素i
        for (int m = 2 * i + 1; m < len; m = 2 * m + 1) { // 从i节点的左节点开始，也就是 2*i - 1处
            if ( m + 1 < len && array[m] < array[m + 1]) { // 如果左子节点小于右子节点，则m指向右子节点
                m++;
            }

            if (array[m] > tmp) { // 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                array[i] = array[m];
                i = m;
            } else {
                break;
            }
        }
        array[i] = tmp; // 将temp值放到最终的位置
    }

    private static void adjustMinHeap(int[] array, int i, int len) {
        int tmp = array[i]; // 取出当前元素i
        for (int m = 2 * i + 1; m < len; m = 2 * m + 1) { // 从i节点的左节点开始，也就是 2*i - 1处
            if ( m + 1 < len && array[m] > array[m + 1]) { // 如果左子节点大于右子节点，则m指向右子节点
                m++;
            }

            if (array[m] < tmp) { // 如果子节点小于父节点，将子节点值赋给父节点（不用进行交换）
                array[i] = array[m];
                i = m;
            } else {
                break;
            }
        }
        array[i] = tmp; // 将temp值放到最终的位置
    }

    private static int[] insertHeap(int[] arr, int x) {
        int len = arr.length + 1;
        int[] newArr = new int[len];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        int i = len - 1;
        while ( i > 0 && newArr[i / 2] < x) {
            newArr[i] = newArr[i / 2];
            i = i / 2;
        }
        newArr[i] = x;
        return newArr;
    }

    private static int[] delHeap(int[] arr) {
        int len = arr.length - 1;
        int[] newArr = new int[len];
        int max = arr[0];
        newArr[0] = arr[len];
        System.out.println("max: " + max);
        System.arraycopy(arr, 1, newArr, 0, len);
        adjustMinHeap(newArr, 0, len);
        return newArr;
    }
}
