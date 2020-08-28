package com.itwrinkly.sword;

/**
 * 数值的整数次方
 * 说明：实现函数Math.pow(base, exponent)高脑功能，求base的exponent次方，不得使用库函数，不需要考虑大数问题
 */
public class Stud16 {
    public static void main(String[] args) {
        int base = 3;
        int exponent = 20;
        long val = repow(base, exponent);
        System.out.println("val:" + val);
    }

    private static long repow(int base, int exponent) {
        int absExp = Math.abs(exponent);
        int result = powAbsExp(base, absExp);
        if (exponent < 0) {
            result = (int) (1.0/result);
        }
        return result;
    }

    private static int powAbsExp(int base, int exponent) {
        if (base == 0 && exponent < 0) throw new RuntimeException("invalid base and exponent");
        if (base == 1 || exponent == 0) return 1;
        int result = 1;
        result *= powAbsExp(base, exponent >> 1);
        if ((exponent & 0x01) == 1) {
            result *= base;
        }
        return result;
    }
}
