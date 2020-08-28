package com.itwrinkly.algorithm;

import java.util.Arrays;

/**
 * 给定一个已经升序排列的数组，找个两数之和等于目标数
 * 函数返回两个下标值index1 和 index2，其中index1必须小于index2
 * tip1: 下标从1开始
 * tip2: 假设每个输入只对应唯一答案，而且不可以使用重复的元素
 */
public class TwoSumI {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        twoSum(arr);
        //反转数组
        int[] datas = {2, 7, 11, 15};
        int left = 0; int right = datas.length - 1;
        while (left < right) {
            datas[left] = datas[left] ^ datas[right];
            datas[right] = datas[left] ^ datas[right];
            datas[left] = datas[left] ^ datas[right];
            left++; right--;
        }
        Arrays.stream(datas).forEach( e -> System.out.println(e));
    }

    private static void twoSum(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int target = 89;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                System.out.println("left:" + (left + 1) + " right:" + (right + 1));
                return;
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
        System.out.println("left:" + (-1) + " right:" + (-1));
    }
}
