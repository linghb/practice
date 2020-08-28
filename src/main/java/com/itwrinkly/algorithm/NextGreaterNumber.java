package com.itwrinkly.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目一：给你一个数组，返回一个等长的数组，对应索引存储着下一个更大元素，如果没有更大的元素，就存 -1
 * 示例：给你一个数组 [2,1,2,4,3]，你返回数组 [4,2,4,-1,-1]
 * 解释：第一个 2 后面比 2 大的数是 4; 1 后面比 1 大的数是 2；第二个 2 后面比 2 大的数是 4; 4 后面没有比 4 大的数，填 -1；3 后面没有比 3 大的数，填 -1
 *
 */
public class NextGreaterNumber {

    public static void main(String[] args) {
        //给你一个数组，返回一个等长的数组，对应索引存储着下一个更大元素，如果没有更大的元素，就存 -1
    }

    private static void greaterNumber() {
        int[] arr = {2, 1, 2, 4, 3};
        Stack<Integer> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while ( ! stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }
            res.add(stack.isEmpty() ? -1 : stack.peek());
            stack.push(arr[i]);
        }

        res.stream().forEach(e -> {System.out.println(e);});
    }
}
