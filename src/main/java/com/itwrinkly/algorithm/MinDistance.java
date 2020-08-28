package com.itwrinkly.algorithm;

/**
 * 给的两个字符串s1 和 s2，计算出将s1 和 s2所使用的最少操作数
 * 你可以对一个字符串做如下三种操作：
 * 1. 插入一个字符
 * 2. 删除一个字符
 * 3. 替换一个字符
 */
public class MinDistance {

    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        int dis = minDistanc(s1, s2);
        System.out.println("dis:" + dis);
    }

    private static int minDistanc(String s1, String s2) {
        if (s1 == null && s2 != null) return s2.length();
        if (s2 == null && s1 != null) return s1.length();
        int m = s1.length(); int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 1;  j<= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                }
            }
        }
        return dp[m][n];
    }
}
