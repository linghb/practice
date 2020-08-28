package com.itwrinkly.sword;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否是出栈顺序
 * 假设压入栈的数字都不相同，例如：序列{1, 2, 3, 4, 5}是某栈的压入顺序，序列
 * {4, 5, 3, 2, 1}是该压栈序列对应的弹出顺序，但{4, 3, 5, 1, 2}则不是
 */
public class Stud31 {

    public static void main(String[] args) {
        int[] pushSeq = {1, 2, 3, 4, 5};
        int[] popSeq = {4, 5, 3, 2, 1};
        boolean isOrder = isPopOrder(pushSeq, popSeq);
        System.out.println("isOrder:" + isOrder);
    }

    private static boolean isPopOrder(int[] pushSeq, int[] popSeq) {
        boolean isOrder = false;
        if (pushSeq != null && popSeq != null && popSeq.length > 0
                && pushSeq.length == popSeq.length) {
            Stack<Integer> stack = new Stack();
            int pushIndex = 0;
            int popIndex = 0;
            while (popIndex < popSeq.length) {
                while ((stack.empty() || stack.peek() != popSeq[popIndex]) && pushIndex < pushSeq.length) {
                    stack.push(pushSeq[pushIndex]);
                    pushIndex++;
                }

                if (stack.peek() != popSeq[popIndex]) {
                    break;
                }

                stack.pop();
                popIndex++;
            }

            if (stack.empty() && popIndex == popSeq.length) {
                isOrder = true;
            }
        }
        return isOrder;
    }
}
