package 栈的压入_弹出序列;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * Created by didi on 30/01/2018.
 */
/*
# 题意
一个是入栈序列,一个出栈序列.
判断入栈序列,是否可以产生出栈序列. 入栈和出栈操作可以是交替进行的.

# 思路来源
推演题目中给出的合法例子和非法例子
使用表格列出推演的.
 (1,2,3,4,5)
  合法: 4,5,3,2,1
  非法: 4,3,5,1,2

# 思路
借助一个栈stack, 比较期望出栈的元素 是否和 当前stack栈顶的元素 一样.
一样: 正常弹出
不一样: 从剩余入栈序列中入栈.  如果没有元素可以入栈,那么弹出序列非法.

# 代码
i: 遍历出栈序列
stack: 模仿真实操作的栈
in: 遍历入栈序列

对每一个期望,从入栈序列中入栈,直到入栈的元素是当前的期望元素.

*/
public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack();
        int in = 0;
        int expected = popA[0];
        boolean findExpected = false;
        for (; in < pushA.length; in++) {
            stack.add(pushA[in]);
            if (pushA[in] == expected) {
                in++;
                stack.pop();
                findExpected = true;
                break;
            }
        }
        if (!findExpected) return false;
        for (int out = 1; out < popA.length; out++) {
//            System.out.println("deal for out-" + out);
            findExpected = false;
            expected = popA[out];
            if (stack.peek() == expected) {
                stack.pop();
                continue;
            }
            //把入栈序列剩余元素入栈,直至期望入栈元素入栈.
            for (; in < pushA.length; in++) {
                stack.add(pushA[in]);
                if (pushA[in] == expected) {
                    stack.pop();
                    in++;
                    findExpected = true;
                    break;
                }
            }
            if (!findExpected) return false;
        }
        return true;
    }

    @Test
    void test() {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {4, 5, 3, 2, 1};
        System.out.println(IsPopOrder(a1, a2));
    }

    @Test
    void test1() {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {4, 3, 5, 1, 2};
        System.out.println(IsPopOrder(a1, a2));
    }

    @Test
    void test11() {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {5, 4, 3, 2, 1};
        System.out.println(IsPopOrder(a1, a2));
    }
}
