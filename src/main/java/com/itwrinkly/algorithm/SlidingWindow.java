package com.itwrinkly.algorithm;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {

    public static void main(String[] args) {

        /**
         * 题一：最小覆盖字符串
         * 给你一个字符串S、一个字符串T，请在字符串S里面找出：包含T所有字母的最小子串
         * 示例：输入：S = "ADOBECODEBANC", T = "ABC"   输出："BANC"
         */
        String str = minWindSubstr();
        System.out.println("str:" + str);

        /**
         * 题二：无重复字符最长子串
         * 给定义一个字符串，请找出其中不含有重复字符的最长子串的长度
         * 示例：输入：S = "abcabcbb"  输出：3
         *      输入：S = "bbbbbb"  输出：1
         */
        int len = maxUniqSubstr();
        System.out.println("len:" + len);
    }

    private static int maxUniqSubstr() {
        String source = "bbbbbbb";
        Map<Character, Integer> window = new HashMap<>();
        int left = 0; int right = 0;
        int maxUniqLen = 0;
        while (right < source.length()) {
            char c = source.charAt(right);

            if (window.get(c) != null) {
                window.put(c, window.get(c) + 1);
            } else {
                window.put(c, 1);
            }
            right++;

            while (window.get(c) > 1) {
                char ch = source.charAt(left);
                window.put(ch, window.get(ch) - 1);
                left++;
            }
            maxUniqLen = right - left > maxUniqLen ? right - left : maxUniqLen;
        }
        return maxUniqLen;
    }

    private static String minWindSubstr() {
        String source = "ADOBECODEBANC";
        String target = "ABC";
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : target.toCharArray()) {
            if (needs.get(c) == null) {
                needs.put(c, 1);
            } else {
                needs.put(c, needs.get(c) + 1);
            }
        }
//        System.out.println("map:" + needs);
        int left = 0; int right = 0; int start = 0;
        int match = 0; int minLen = Integer.MAX_VALUE;

        while (right < source.length()) {
            Character c = source.charAt(right);

            if (needs.get(c) != null && needs.get(c) > 0) {
                if (window.get(c) != null) {
                    window.put(c, window.get(c) + 1);
                } else {
                    window.put(c, 1);
                }

                if (window.get(c) == needs.get(c)) {
                    match++;
                }
            }
            right++;

            while (match == needs.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                char ch = source.charAt(left);
                if (needs.get(ch) != null && needs.get(ch) > 0) {
                    window.put(ch, window.get(ch) - 1);
                    if (window.get(ch) < needs.get(ch)) {
                        match--;
                    }
                }
                left++;
            }

        }
        return minLen == Integer.MAX_VALUE ? "" : source.substring(start, start + minLen);
    }
}
