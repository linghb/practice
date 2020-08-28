package com.itwrinkly.sword;

public class Stud29 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        clockWise(matrix);
    }

    private static void clockWise(int[][] matrix) {
        int rows = matrix.length;
        if (matrix == null || rows == 0 ) return;
        if (rows == 0 || matrix[0].length == 0) return;
        int columns = matrix[0].length;
        int start = 0;
        while (rows > start * 2 && columns > start * 2) {
            printClockWise(matrix, rows, columns, start);
            start++;
        }
    }

    private static void printClockWise(int[][] matrix, int rows, int columns, int start) {
        int endX = rows - start - 1;
        int endY = columns - start - 1;
        int i = start;
        for (; i <= endY; i++) {
            System.out.print(matrix[start][i] + ",");
        }

        if (endX > start) {
            for (int j = start + 1; j <= endX; j++) {
                System.out.print(matrix[j][endY] + ",");
            }

            if (endY > start) {
                for (int m = endY - 1; m >= start; m--) {
                    System.out.print(matrix[endX][m] + ",");
                }

                if (endX - start > 1) {
                    for (int n = endX - 1; n > start; n--) {
                        System.out.print(matrix[n][start] + ",");
                    }
                }
            }


        }



    }
}
