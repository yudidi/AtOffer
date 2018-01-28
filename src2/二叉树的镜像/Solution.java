package 二叉树的镜像;

import common.TreeNode;

/**
 * Created by didi on 28/01/2018.
 */

/*
# 题意
反转二叉树: 左子树变右子树. 对单个节点而言,左右孩子指针互换.

# 思路
1. 交换当前节点的左右子树.
2. 递归调用,翻转当前节点的左子树和右子树.

# 函数签名
1. void Mirror(TreeNode root) // 翻转以root为根的这颗树.

# 复杂度
T(n): 其实主要操作就是,交换每个节点的左右孩子指针, 所以是 O(n)
S(n): 每个节点对应一个递归函数的调用,每次调用使用O(1)的临时变量,所有是O(n)
 */

public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null){
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        Mirror(root.left);
        Mirror(root.right);
    }
}