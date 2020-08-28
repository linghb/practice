package com.itwrinkly.algorithm;

/**
 * 字符串四则运算
 * 1、乘法：给定两个字符串形式的非负整数num1 和 num2 ，返回 num1 和 num2 的乘积，他们的乘积也表示为字符串的形式
 * 注意：num1 和 num2 可以非常长，所以不可以把他们直接转成整型然后运算，唯一的思路就是模仿我们手算乘法
 *
 * 2、加法
 */
public class StringFourOper {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "45";
        //字符串乘法
        String str = strsProduct(num1, num2);
        System.out.println("str:" + str);
    }

    private static String strsProduct(String num1, String num2) {
        if (num1 == null || num2 == null) return "";
        int m = num1.length(); int n = num2.length();
        int[] res = new int[m + n];
        for (int i = m -1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j; int p2 = i + j + 1;
                int sum = product + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }

        String str = "";
        for (; i < res.length; i++) {
            str += res[i];
        }
        return str;
    }
}
