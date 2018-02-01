package 栈的压入_弹出序列;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * Created by didi on 30/01/2018.
 */

/*
# 题意

# 优化点
我的思路,并不是真正的还原入栈的过程. 而是不断的考察期望出栈的元素, 然后从入栈序列中寻找这个期望的出栈元素. 我的思路反了.
正确的还原思路是:  不断的入栈, 入栈之后再考察是否需要出栈.  需要出栈则出栈,否则继续入栈. 最后辅助栈空了,说明全部都出栈了,并且是按照出栈序列出栈的.
*/
public class Solution2 {

    //TODO
    /*
    这才是真正的还原入栈过程, 首先入栈,然后看是否需要出栈, 不是则继续入栈.
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while (!s.empty() && s.peek() == popA[popIndex]) {
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }

    public boolean IsPopOrder1(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < popA.length; i++) {
            stack.push(pushA[i]);
            while (j < popA.length && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty() ? true : false;
    }
}
