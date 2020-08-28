package com.itwrinkly.algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数k，找出该数组中和为k的连续子数组的个数
 * 示例：
 * 输入：nums = [1, 1, 1, 1], k = 2
 * 输出：2  [1,1] 和 [1, 1]为两种不同情况
 */
public class PrefixArraySum {

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, -2, 4, 1};
        int k = 5;
        //方法一：暴力破解法 时间复杂O(N ^ 2)
        prefixSum(nums, k);

        System.out.println("--------------");
        //方法二：哈希法 时间复杂O(N)
        int res = prefixSumHash(nums, k);
        System.out.println("res:" + res);

    }

    private static int prefixSumHash(int[] nums, int k) {
        Map<Integer, IndexCount> preSum = new HashMap<>();
        int res = 0; int sum0_i = 0;
        for (int i = 0; i < nums.length; i++) {
            sum0_i += nums[i];
            int sum0_j = sum0_i - k;
            if (preSum.containsKey(sum0_j)) {
                IndexCount idx = preSum.get(sum0_j);
                System.out.println("i:" + i + " j:" + (idx.getIndex() + 1) + " count:" + idx.getCount());
                res += idx.getCount();
            }

            if (preSum.get(sum0_i) == null) {
                IndexCount idx = new IndexCount(i, 1);
                preSum.put(sum0_i, idx);
            } else {
                IndexCount idx = preSum.get(sum0_i);
                idx.setCount(idx.getCount() + 1);
                preSum.put(sum0_i, idx);
            }
        }
        return res;
    }

    private static int prefixSum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] =  preSum[i] + nums[i];
        }

        int res = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i ; j++) {
                if (preSum[i] - preSum[j] == k) {
                    System.out.println("i:" + (i - 1) + " j:" + j);
                    res++;
                }
            }
        }
        return res;
    }

    @Data
    @AllArgsConstructor
    private static class IndexCount {
        private int index;
        private int count;
    }
}
