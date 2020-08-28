package com.itwrinkly.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 假设盘子上有 n 块面积大小不一的烧饼，你如何用一把锅铲进行若干次翻转，让这些烧饼的大小有序（小的在上，大的在下）？
 * 示例：
 * 输入：[3, 2, 4, 1]
 * 输出：[4, 2, 4, 3]
 * 解释：执行4次煎饼翻转，k值分别为4， 2， 4 和 3
 * 第一次翻转后 k = 4： A = [1, 4, 2, 3]
 * 第二次翻转后 k = 2： A = [1, 4, 2, 3]
 * 第三次翻转后 k = 4： A = [1, 4, 2, 3]
 * 第四次翻转后 k = 3： A = [1, 4, 2, 3]
 *
 * 特例：
 * 输入：[2, 3] 或者 [3, 3]
 * 输出：[]
 */
public class PanCakeSort {

    public static List<Integer> res = new ArrayList<>();
    public static void main(String[] args) {

//        int[] cakes = {3, 2, 4, 1};
        int[] cakes = {3, 3};
        panCakeSort(cakes, cakes.length);
        System.out.println("res:" + res);
//        Arrays.stream(cakes).forEach(e -> System.out.println(e));
    }

    private static void panCakeSort(int[] cakes, int length) {
        if (cakes == null || cakes.length < 2 || length < 2 || isSeq(cakes, length)) return;
        //寻找最大饼索引
        int maxIndex = 0;
        int maxVal = 0;
        for (int i = 0 ; i < length; i++) {
            if (cakes[i] > maxVal) {
                maxVal = cakes[i];
                maxIndex = i;
            }
        }

        //第一次翻转，最大饼翻到最上面
        reverse(cakes, 0, maxIndex);
        res.add(maxIndex + 1);
        //第二次翻转，将最大饼翻到最下面
        reverse(cakes, 0, length - 1);
        res.add(length);

        //递归翻转剩余饼
        panCakeSort(cakes, length - 1);
    }

    private static boolean isSeq(int[] cakes, int len) {
        for (int i = 1; i < len; i++) {
            if (cakes[i] < cakes[i - 1]) return false;
        }
        return true;
    }

    private static void reverse(int[] cakes, int i, int j) {
        while (i < j) {
            cakes[i] = cakes[i] ^ cakes[j];
            cakes[j] = cakes[i] ^ cakes[j];
            cakes[i] = cakes[i] ^ cakes[j];
            i++; j--;
        }
    }
}
