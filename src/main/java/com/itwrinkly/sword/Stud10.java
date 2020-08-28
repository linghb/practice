package com.itwrinkly.sword;

/**
 * 斐波那契额数列题目：
 * 1. 求斐波那契额数列的第n项值
 * 2. 一只青蛙一次可以跳1级台阶，也可以跳2级台阶，求该青蛙跳上一个n级台阶共有多少种跳法
 * 3. 一只青蛙一次可以跳1级台阶，也可以跳2级....n级台阶，求该青蛙跳上一个n级台阶共有多少种跳法
 */
public class Stud10 {
    public static void main(String[] args) {
        //题1：
        System.out.println("fabonacci:" + fabonacci(10));
        //题2：
        System.out.println("frog1:" + frog1(4));
        //题3：
        System.out.println("frog2:" + frog2(10));
    }

    private static int frog2(int n) {
        return 0;
    }

    private static int frog1(int n) {
        if (n <=0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return frog1(n - 1) + frog1(n - 2);
    }

    private static long fabonacci(long n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fabonacci(n-1 ) + fabonacci(n - 2);
    }
}
