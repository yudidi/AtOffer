package 二叉树中和为某一值的路径;

import chapter6.TreeUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by didi on 02/02/2018.
 */
/*
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

# 题意
在二叉树找出所有这样的路径: 路径中所有节点的值的综合等于target.

# 疑问
Q: 路径的一定是叶子节点吗?
A: 是的, 路径的起点必须是根节点,终点必须是叶子节点.

# 思路
f(root,target) = f(root.left,target-root.val) and f(root.right,target-root.val)
深度优先搜索: 从左子树和右子树查找到路径和为(target-root.val)的路径. 当找到要求路径和为0,并且root=null

递归终止条件: sum = root.val 且 root是叶子节点.
# 代码
函数签名: 根节点,剩余的路径和, 存放一条路径的结果,存放所有路径的结果.
1. 递归终止:sum = root.val 且 root是叶子节点 这条路径放入所有路径集合.
2. if(sum<root) 终止
3. else (sum>root) 继续从左子树和右子树查找路径和为sum-root的路径.

# 代码2
终止条件: sum = 0 且 root = null.  ==>这样会重复放入路径, 考虑递归终止的节点是null和null,都要放入一次路径.

 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        core(root, target, null, paths);
        return paths;
    }

    private void core(TreeNode root, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> paths) {
        if (root == null) return;
        if (path == null) {
            path = new ArrayList<>();
        }
        if (sum < root.val) return;
        if (root.left == null && root.right == null && sum == root.val) {
            path.add(root.val);
            paths.add(path);
        }
        if (sum > root.val) {
            path.add(root.val);
            core(root.left, sum - root.val, new ArrayList<>(path), paths);
            core(root.right, sum - root.val, new ArrayList<>(path), paths);
        }
    }

    /*
        测试用例:
    {10,5,12,4,7},22

    对应输出应该为:

    [[10,5,7],[10,12]]

    你的输出为:

    [[10,5,4,7,12],[10,5,4,7,12]]
         */

    @Test
    void test() {
        String pre = "542##1##3#1##";
//        TreeNode root = TreeUtils.createTree3ByPreInput(pre);
//        TreeUtils.printTreePreOrder(root);
//        ArrayList<ArrayList<Integer>> paths = FindPath(root, 9);
//        paths.stream().forEach(path -> System.out.println(path));
    }
}
