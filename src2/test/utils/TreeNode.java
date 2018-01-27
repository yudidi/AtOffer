package test.utils;

/**
 * Created by didi on 25/01/2018.
 */

public class TreeNode<T> {
    public T val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(){

    }

    TreeNode(T x) {
        this.val = x;
    }
}
