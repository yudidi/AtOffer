package 二叉树中和为某一值的路径.FrequentBug;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class FrequentBug {
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
}
