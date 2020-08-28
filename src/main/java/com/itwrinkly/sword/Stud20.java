package com.itwrinkly.sword;

import sun.jvm.hotspot.debugger.linux.LinuxDebugger;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如：字符串"+100"、"5e2"、"-123"、 "3.1415"
 * 以及"-1E-16"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"以及"12e+5.4"都不是
 */
public class Stud20 {

    public static void main(String[] args) throws NoSuchFieldException {
//        char[] str = "123.45e+6".toCharArray();
//        char[] str = "1.2.3".toCharArray();
        char[] str = "+-5".toCharArray();
        System.out.println("result:" + isNum(str));
    }

    private static void method(AtomicInteger in) {
        in.incrementAndGet();
    }

    private static boolean isNum(char[] str) {
        if (str == null) return false;
        AtomicInteger indx = new AtomicInteger(0);
        boolean numberic = scanInt(str, indx);
        if (str[indx.get()] == '.') {
            indx.incrementAndGet();
            numberic = scanUnsignInt(str, indx) || numberic;
        }

        if (str[indx.get()] == 'E' || str[indx.get()] == 'e') {
            indx.incrementAndGet();
            numberic = numberic && scanInt(str, indx);
        }
        return numberic && (indx.get() == str.length);
    }

    private static boolean scanInt(char[] str, AtomicInteger indx) {
        if (str[indx.get()] == '+' || str[indx.get()] == '-') {
            indx.incrementAndGet();
        }
        return scanUnsignInt(str, indx);
    }

    private static boolean scanUnsignInt(char[] str, AtomicInteger indx) {
        int begin = indx.get();
        while (indx.get() <= str.length - 1 && str[indx.get()] >= '0' && str[indx.get()] <= '9') {
            indx.incrementAndGet();
        }
        return indx.get() > begin;
    }
}
