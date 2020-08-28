package com.itwrinkly.sword;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 请设计一个函数，用来判断在矩阵中是否存在一条包含某个字符串所有字符的路径
 * 路径可以从矩阵任意一格开始，每一步可以从左、右、上、下移动一格。如果一条
 * 路径经过某一格，那么该路径不能再次进入该格子
 */
public class Stud12 {
    static AtomicInteger index = new AtomicInteger(0);
    public static void main(String[] args) {
        String[][] matrix = {
                {"a", "b", "t", "g"},
                {"c", "f", "c", "s"},
                {"j", "d", "e", "h"}
        };
        boolean[][] zone = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                zone[i][j] = false;
            }
        }

        boolean exist = findPath(matrix, "bfc9", zone);
        System.out.println("exist:" +  exist);
    }

    private static boolean findPath(String[][] matrix, String str, boolean[][] zone) {
        if (str == null || str.length() <= 0
                || matrix == null || matrix.length <= 0) return false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (hasPath(matrix, row, col, str, zone)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPath(String[][] matrix, int row, int col, String str, boolean[][] zone) {
        boolean hasPath = false;
        if (index.get() >= str.length()) return true;
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length
                && str.substring(index.get(), index.get() + 1).equals(matrix[row][col]) && ! zone[row][col]) {
            zone[row][col] = true;
            index.incrementAndGet();
            hasPath = hasPath(matrix, row - 1, col, str, zone) || hasPath(matrix, row + 1, col, str, zone)
                    || hasPath(matrix,  row, col - 1, str, zone) || hasPath(matrix, row, col + 1, str, zone);
            if (! hasPath) {
                index.decrementAndGet();
                zone[row][col] = false;
            }
        }
        return hasPath;
    }
}
