package com.itwrinkly;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        System.out.println("加载当前类的加载器:" + App.class.getClassLoader());
        System.out.println("加载应用程序类加载器的加载器"
                + App.class.getClassLoader().getClass().getClassLoader());
    }
}
