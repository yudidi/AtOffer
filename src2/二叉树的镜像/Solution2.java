package 二叉树的镜像;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by didi on 28/01/2018.
 */

/*
# 非递归实现

# 优化 => 从运行结果看, 空间和时间都没有什么优化
减少递归调用消耗时间,
较少空间消耗.

# 思路
递归改为=>非递归: 因为递归是深度优先遍历的前序, 所以使用stack作为辅助空间.

# 复杂度
T(n): 遍历全部节点, O(n)
S(n): 两个临时变量, 一个栈, O(2) + O(n)

# 扩展
因为子树的反转,不会影响父亲树, 所以使用三种深度优先遍历 或 层次遍历 都是可行的, 所以辅助空间可以是stack或queue.

 */

public class Solution2 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode tmp = null, cur = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur == null) {
                continue;
            }
            tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            stack.add(cur.left);
            stack.add(cur.right);
        }
    }

    //非递归层次遍历
    public void Mirror2(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode tmp = null, cur = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            cur = queue.remove();
            if (cur == null) {
                continue;
            }
            tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            queue.add(cur.left);
            queue.add(cur.right);
        }
    }
}