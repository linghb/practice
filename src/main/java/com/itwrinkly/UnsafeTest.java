package com.itwrinkly;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {
    public static void main(String[] args) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        System.out.println("unsafe:" + unsafe);
        Integer a = new Integer(1);
        Integer b = new Integer(2);
        swapInte(a, b);
        System.out.println("main swap:" + a  + "," +b );
    }

    private static void swapInte(Integer a, Integer b) {
        System.out.println("swap before:" + a  + "," +b );
        Integer tmp = a;
        a = b;
        b = tmp;
        System.out.println("swap after:" + a  + "," +b );
    }
}
