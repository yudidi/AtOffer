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
定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
实现一个数据结构,栈,除了出栈,入栈,还有个函数能够返回栈的最小值.

# 思路
1. 封装一个stack, 直接使用stack的push,pop,top, 自己实现一个Min(遍历栈取得最小值)
min: O(n).
push: O(1).
pop: O(1)
# 思路2
保证最小值在栈顶. xxx, 这个思路不行, 破坏LIFO的栈特性.
push: O(n)
pop: O(1)
min: O(1)

# 思路3
使用stack + 一个排序数组,升序存放栈中元素.
push: O(1) + O(nlogn)
pop: O(1) + O(log) + O(n)  => Q: 是否可以处理重复元素的情况. A: 可以, 因为stack和arr同时删除重复元素的一个,剩下重复元素,不会影响下一次push,pop,min的结果
min: O(1) + n-1次移动操作.

# 思路4
stack+ min heap
push: O(1) + O(logn)
pop: O(1) + O(logn)
min: O(1) + adjust heap( << logn)

 */
public class Solution {
    private Stack<Integer> stack;
    private PriorityQueue<Integer> minheap;

    public void push(int node) {
        if (stack == null) {
            stack = new Stack<>();
            minheap = new PriorityQueue();
        }
        stack.add(node);
        minheap.add(node);
    }

    public void pop() {
        minheap.remove(stack.pop());//如果有重复元素,任意移除一个,不会影响下一次的min();  //找到这个元素: O(logn) + 删除这个元素调整堆: O(logn)
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minheap.peek();
    }

    @Test
    void testFunction() {
        Solution s = new Solution();
        s.push(1);
        System.out.println(s.min());
        s.push(2);
        System.out.println(s.min());
    }

    //PriorityQueue创建小顶堆的三种方法.
    @Test
    void test() {
        PriorityQueue<Integer> minheap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {//技巧: 假设传入1,2, 要想得到1,2 ,那么必须返回整数或0; 要想得到2,1,返回负数.
                return o1 - o2;
            }
        });
        minheap.add(1);
        minheap.add(2);
        System.out.println(minheap);
    }

    @Test
    void test2() {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        minheap.add(1);
        minheap.add(2);
        System.out.println(minheap);
    }

}
