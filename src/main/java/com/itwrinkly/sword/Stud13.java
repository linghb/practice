package com.itwrinkly.sword;

/**
 * 剪绳子：给你一根长度为n的绳子，把绳子剪成m段（m, n是整数，m > 1 且 n > 1），每段绳子长度记为：k[0]...k[m]
 * 请问k[0] * k[1] * ... k[m]可能的最大乘积是多少？例如：当绳子长度我8时，把它剪成2，3，3三段得最大乘积18
 */
public class Stud13 {
    public static void main(String[] args) {
        //方法1：动态规划
        int len = 8;
        int product = productDp(len);
        System.out.println("dp product:" + product);
        //方法2：贪心算法
        product = productGreed(len);
        System.out.println("greed product:" + product);
    }

    private static int productGreed(int len) {
        if (len < 2) return 0;
        if (len == 2) return 1;
        if (len == 3) return 2;
        int timesOf3 = len / 3;
        if (len - timesOf3 * 3 == 1) {
            timesOf3 -= timesOf3;
        }
        int timesOf2 = (len - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }

    private static int productDp(int len) {
        if (len < 2) return 0;
        if (len == 2) return 1;
        int[] products = new int[len + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for (int i = 4; i <= len; i++) {
            int max = 0;
            for (int j = 1; j <= i/2; j++) {
                int product = products[j] * products[i - j];
                if (product > max) {
                    max = product;
                }
                products[i] = max;
            }

        }
        return products[len];
    }
}
