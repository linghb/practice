package com.itwrinkly.sword;

/**
 * 请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配
 */
public class Stud19 {

    public static void main(String[] args) {
        char[] str = "aaa".toCharArray();
        char[] pattern = "ab*ac*a.".toCharArray();
        System.out.println("match:" + strMatch(str, pattern));
    }

    private static boolean strMatch(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;
        return matchRecur(str, pattern, 0, 0);
    }

    private static boolean matchRecur(char[] str, char[] pattern, int strInx, int patternInx) {
        if (strInx == str.length && patternInx == pattern.length) return true;
        if (strInx <= str.length - 1 && patternInx == pattern.length) return false;
        if (strInx == str.length && patternInx < pattern.length) return false;
        if (patternInx + 1 < pattern.length && pattern[patternInx + 1] == '*') {
            if (str[strInx] == pattern[patternInx] || (pattern[patternInx] == '.' && strInx < str.length)) {
                return matchRecur(str, pattern, strInx + 1, patternInx +2)
                        || matchRecur(str, pattern, strInx + 1, patternInx)
                        || matchRecur(str, pattern, strInx, patternInx +2);
            } else {
                //ignore '*'
                return matchRecur(str, pattern, strInx, patternInx + 2);
            }
        }

        if (str[strInx] == pattern[patternInx] || (pattern[patternInx] == '.' && strInx < str.length)) {
            return matchRecur(str, pattern, strInx + 1, patternInx + 1);
        }
        return false;
    }
}
