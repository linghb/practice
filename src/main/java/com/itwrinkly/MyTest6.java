package com.itwrinkly;

public class MyTest6 {
    public static void main(String[] args) {
        Single instance = Single.getInstance();
        System.out.println("count1:" + Single.count1);
        System.out.println("count2:" + Single.count2);
        System.out.println("count2:" + instance.count2);
        System.out.println("ClassLoader:" + ClassLoader.getSystemClassLoader());
        System.out.println("MyTest6:" + MyTest6.class.getClassLoader());

        int n = 16;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n+1);
        System.out.println(Integer.highestOneBit(5));

        Integer one = 1;
        Integer two = 2;
        System.out.println("one:" + one + ", two:" + two);
        swapInt(one, two);
        System.out.println("one:" + one + ", two:" + two);
    }

    private static void swapInt(Integer one, Integer two) {
        System.out.println("one:" + one + ", two:" + two);
        Integer tmp = one;
        one = two;
        two = tmp;
        System.out.println("one:" + one + ", two:" + two);
    }
}
class Single{
    public static int count1;

    private static Single single = new Single();
    private Single(){
        count1++;
        count2++;
        System.out.println("构造方法count1:" + count1);
        System.out.println("构造方法count2:" + count2);
    }
    public static int count2 = 0;
    public static Single getInstance(){
        return single;
    }
}