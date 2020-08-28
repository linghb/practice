package com.itwrinkly.algorithm;

import java.util.Arrays;

/**
 * 给定n个非负整数表示每个宽度为1的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 * 示例：输入：[0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
 * 输出：6
 */
public class RainTrap {

    public static void main(String[] args) {
        int[] inputs = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //方法一：暴力破解法
        //int res = violenceTrap(inputs);

        //方法二：备份法
        //int res = memTrap(inputs);

        //方法二：双指针法
        int res = doublePointTrap(inputs);

        System.out.println("res:"+ res);

        int[] arr = {1, 4, 3, 2};
        Arrays.sort(arr);
        int result = 0;
        for (int i = 0; i < arr.length; i += 2) {
            result += arr[i];
        }
        System.out.println("result:" + result);
    }

    private static int doublePointTrap(int[] inputs) {
        int left = 0;
        int right = inputs.length - 1;
        int res = 0;
        int leftMax = inputs[0];
        int rightMax = inputs[inputs.length - 1];
        while (left <= right) {
            leftMax = Math.max(leftMax, inputs[left]);
            rightMax = Math.max(rightMax, inputs[right]);
            if (leftMax < rightMax) {
                res += leftMax - inputs[left];
                left++;
            } else {
                res += rightMax - inputs[right];
                right--;
            }
            System.out.println("cal res:" + res);
        }
        return res;
    }

    private static int memTrap(int[] inputs) {
        int[] leftMaxs = new int[inputs.length];
        int[] rightMaxs = new int[inputs.length];
        //初始化base case
        leftMaxs[0] = 0;
        rightMaxs[inputs.length - 1] = inputs[inputs.length - 1];
        for (int i= 1; i < inputs.length; i++) {
            leftMaxs[i] = Math.max(leftMaxs[i - 1], inputs[i]);
        }

        for (int i = inputs.length - 2; i >=0; i--) {
            rightMaxs[i] = Math.max(inputs[i], rightMaxs[i + 1]);
        }

        int res = 0;
        for (int i= 1; i < inputs.length - 1; i++) {
            res += Math.min(leftMaxs[i], rightMaxs[i]) - inputs[i];
        }
        return res;
    }

    private static int violenceTrap(int[] inputs) {
        int res = 0;
        if (inputs != null && inputs.length != 1) {
            for (int i = 1; i < inputs.length - 1; i++) {
                int leftMax = 0; int rightMax = 0;
                for (int j= 0; j <= i; j++) {
                    leftMax = Math.max(leftMax, inputs[j]);
                }

                for (int j = i; j < inputs.length; j++) {
                    rightMax = Math.max(rightMax, inputs[j]);
                }
                //System.out.println("hight:" + (Math.min(leftMax, rightMax) - inputs[i]));
                res += Math.min(leftMax, rightMax) - inputs[i];
            }
        }
        return res;
    }
}
