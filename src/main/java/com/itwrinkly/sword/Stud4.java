package com.itwrinkly.sword;

/**
 * 二维数组中的查找：二维数组每行每列从左到右、从上到下分别依次递增，现输入一个任意整数，判断该数组中是否含有该数字
 */
public class Stud4 {
    public static void main(String[] args) {
        int matrix[][] = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int k = 16;
        boolean flag = find(matrix, k);
        System.out.println("find the k:" + k + " is " + flag);
    }

    private static boolean find(int[][] matrix, int k) {
        if (matrix == null || matrix.length < 1) return false;
        int row = 0;
        int column = matrix[0].length - 1;
        while(row < matrix.length && column >=0) {
            if (matrix[row][column] == k) return true;
            if (matrix[row][column] > k) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
