package 树的子结构;

import test.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
# 题意:
1.输入两棵树A,B,判断后者是否是前者的子结构
2. 约定空树null不是任何树的子树.

# 疑问
Q1: 如果A中存在一个与B地址相等的结点?那么B肯定是A的子结构吗?
A: 问考官.

Q2: 什么叫前者是后者的子结构.
A: A,B两棵树的结构一模一样,且,A,B中每个节点一一对应,全部相等.
A: (注意不是地址相等,否则一次遍历就完成了).

Q3: 两颗相等的树, 可以构成子结构的关系吗?
A: A与B相等, B是A的子结构

Q4: A: [1,2,3]  B1:[1], B2:[2], B1,B2是A的子结构吗?
A: B1,B2都是A的子结构

Q5: A[1,2,3]的子结构有哪些
A: [1] [2] [3]  [1,2] [2,3] [1,3(right)] [1,2,3]

# 思路
1. 层序遍历A树,找到与b.val相等的节点cur.  =>Q:为什么用BFS,不用DFS.  A:考虑子结构在A中的不同位置(上下左右),不同的遍历方式,找到子结构的速度不同.
2. 判断cur为根的子树和B为根的树的全部节点是否相等. => 递归判断cur左子树 值等 B.左子树.

# 函数签名
f1: boolean HasSubtree(test.utils.TreeNode root1, test.utils.TreeNode root2), 判断root2是否是root1的子结构
f2: boolean Equals(node1,node2), 判断两颗树是否值相等

# 时间复杂度
f1: O(n), 遍历全部节点
f2: O(n), n层递归, 每层O(1)
汇总: O(n2), f1嵌套f2.

# 空间复杂度
O(n): 借助队列实现层序遍历.

 */
public class Solution2 {
    //
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        return false;
    }

}
