package com.itwrinkly.algorithm;

import java.math.BigDecimal;

public class Factorial {
    public static void main(String args[]){
        int i,j;
        BigDecimal sum = BigDecimal.valueOf(0);
        int scope = 7;
        for(i = 2;i <= scope;i++){
            for(j = 2;j < Math.sqrt(i);j++){
                if(i%j==0)
                break;
            }
            if(j > Math.sqrt(i)){
                //System.out.println(i+"是素数");
                //得到素数后累加
                BigDecimal product = BigDecimal.valueOf(1);
                for (int m = 1; m <= i; m++) {
                    product = product.multiply(new BigDecimal(m));
                }
                sum = sum.add(product);
            }
//            else {
//                System.out.println(i + "不是素数");
//            }
        }
        System.out.println("sum:" + sum.toString());
    }

}