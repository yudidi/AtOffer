package 包含min函数的栈;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by didi on 30/01/2018.
 */
/*
# 题意
定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数. 要求push,pop,min都是O(1)时间复杂度
实现一个数据结构,栈,除了出栈,入栈,还有个函数能够返回栈的最小值.

# 破题
要求min是O(1),所以每个状态下的最小值都应该是被保存的, 并且随着入栈和出栈被更新,或者保持不变>

* 举例,画图
1,2,3,0

 */
public class Solution2 {

    public void push(int node) {
    }

    public void pop() {
    }

    public int top() {
        return 0;
    }

    public int min() {
        return 0;
    }
}
