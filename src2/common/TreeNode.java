package common;

import org.junit.jupiter.api.Test;

/**
 * Created by didi on 25/01/2018.
 */

//public class TreeNode<T> {
//    public T val;
//    public TreeNode left;
//    public TreeNode right;
//
//    public TreeNode(){
//
//    }
//
//    public TreeNode(T x) {
//        this.val = x;
//    }
//}

public class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode(int val) {
       this.val = val;
    }
}

class XX{
    @Test
    void test(){
        TreeNode root = new TreeNode('1');
        System.out.println(root.val);
    }

    @Test
    void test1(){
        TreeNode root = new TreeNode(1);
        System.out.println(root.val);
    }

    @Test
    void test11(){
        TreeNode root = new TreeNode(1);
        System.out.println(root.val);
    }
}