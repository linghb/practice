package com.itwrinkly.sword;

/**
 * 用高效的方式求出：一个整数的二进制表示含有1的个数（需要思考正负数、整数范围）
 */
public class Stud15 {
    public static void main(String[] args) {
        int n = 19;
        System.out.println("bit:" + Integer.toBinaryString(n));
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
            System.out.println("n:" + n);
        }
        System.out.println("count:" + count);
    }
}
