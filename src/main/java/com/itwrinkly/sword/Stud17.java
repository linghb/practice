package com.itwrinkly.sword;

import java.util.Arrays;

/**
 * 输入数字n，按顺序打印出从1到最大的n位十进制数，如输入3，则打印出1、2、3一直到最大的3位数999
 * 注意陷阱：
 * 1、int 和 long类型溢出
 * 2、时间复杂度
 */
public class Stud17 {
    public static void main(String[] args) {
        int n = 3;
        //方法一：数组每位上0 ~ 9的全排列
        permprint1toN(n);
        //方法二：非递归方法，从最高位开始一步步累加并累计位数，一直到最大数为止
    }

    private static void permprint1toN(int n) {
        if (n <= 0) return;
        char[] numbers = new char[n];
        Arrays.fill(numbers, '0');
        for (int i = 0; i < 10; i++) {
            numbers[0] = (char) (i + '0');
            print1toNRecur(numbers, n, 0);
        }
    }

    private static void print1toNRecur(char[] numbers, int len, int index) {
        if (index == len - 1) {
            printNumber(numbers);
            return;
        }
        for (int i = 0; i < 10; i++) {
            numbers[index] = (char) (i + '0');
            print1toNRecur(numbers, len, index + 1);
        }
    }

    private static void printNumber(char[] numbers) {
        if (numbers == null || numbers.length <=0) return;
        boolean isBeginZero = true;
        for (int i = 0; i < numbers.length; i++) {
            if (isBeginZero && numbers[i] != '0') {
                isBeginZero = false;
            }
            if (!isBeginZero) {
                System.out.print(numbers[i]);
            }
        }
        System.out.println();
    }
}
