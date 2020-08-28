package com.itwrinkly;

public class StaticTest
{
   public static void main(String[] args)
   {
       staticFunction();
   }

   static StaticTest st = new StaticTest();



   StaticTest()
   {
       System.out.println("3");
       System.out.println("a="+a+",b="+b);
   }

   public static void staticFunction(){
       System.out.println("4");
   }

   int a=110;
   static int b =112;

    static
    {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }
}