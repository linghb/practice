package com.itwrinkly.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermAndCombina {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        //枚举1: 数学归纳法
//        List<String> res = enumeColl(arr, arr.length);
//        System.out.println("subsets:" + res);

        //枚举2：回溯法
//        List res2 = new ArrayList<>();
//        List track = new ArrayList<>();
//        enumeColl2(arr, 0, res2, track);
//        System.out.println("subsets2:" + res2);

        //排列
        List res3 = new ArrayList<>();
        List track3 = new ArrayList<>();
        perm(arr, res3, track3);
        System.out.println("perm:" + res3);

        //组合，2个为一组
        List res4 = new ArrayList<>();
        List track4 = new ArrayList<>();
        int k = 2;
        combine(arr, 0, k, res4, track4);
        System.out.println("combine:" + res4);
    }

    private static void combine(int[] arr, int index, int k, List res4, List track4) {
        if (track4.size() == 2) {
            res4.add(new ArrayList<>(track4));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            track4.add(arr[i]);
            combine(arr, i + 1, k, res4, track4);
            track4.remove(track4.size() - 1);
        }
     }


    private static void perm(int[] arr, List res3, List track3) {
        if (track3.size() == arr.length) {
            res3.add(new ArrayList(track3));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (track3.contains(arr[i])) continue;
            track3.add(arr[i]);
            perm(arr, res3, track3);
            track3.remove(track3.size() - 1);
        }
    }

    private static void enumeColl2(int[] arr, int index, List res2, List track) {
        res2.add(new ArrayList<>(track));
        for (int i = index; i < arr.length; i++) {
            track.add(arr[i]);
            enumeColl2(arr, i + 1, res2, track);
            track.remove(track.size() - 1);
        }
    }

    private static List<String> enumeColl(int[] arr, int len) {
        if (len == 0) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        List<String> res = enumeColl(arr, len - 1);
        int size = res.size();
        for (int i = 0; i < size; i++) {
            String s = res.get(i);
            s += arr[len - 1] ;
            res.add(s);
        }
        return res;
    }
}
