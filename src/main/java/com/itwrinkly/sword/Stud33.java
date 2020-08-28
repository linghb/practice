package com.itwrinkly.sword;

/**
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历
 * 结果。如果是则返回true，否则返回false。假设输入的数组任意两个都不重复。
 * 例如，输入数组{5, 7, 6, 9, 11, 10, 8}，则返回true；如果输入的数组为
 * {7, 4, 6, 5}则没有哪颗二叉搜索树的后序遍历是这个结果
 */
public class Stud33 {

    public static void main(String[] args) {
        //int[] arr = {5, 7, 6, 9, 11, 10, 8};
        int[] arr = {7, 4, 6, 5};
        boolean flag = verifyPostOrer(arr, 0, arr.length - 1);
        System.out.println("flag:" + flag);
    }

    private static boolean verifyPostOrer(int[] arr, int start , int end) {
        if (arr == null) return false;
        int point = start;
        for (; point < end; point++) {
            if (arr[point] > arr[end]) {
                break;
            }
        }

        for (int i = point; i < end; i++) {
            if (arr[i] < arr[end]) {
                return false;
            }
        }

        boolean left = true;
        boolean right = true;
        if (point - start > 0) {
            left = verifyPostOrer(arr, start, point - 1);
        }

        if (end - point > 0) {
            right = verifyPostOrer(arr, point, end - 1);
        }
        return left && right;
    }
}
