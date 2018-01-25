package chapter6.stack;

import chapter6.TreeUtils;
import chapter6.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by didi on 25/01/2018.
 */
public class Solution {

    //非递归前序遍历
    public void printTreePreOrderNotRecursive(int[] arr){
        TreeNode root = TreeUtils.createTree(arr,arr.length);
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null) continue;
            stack.add(node.getRight());
            stack.add(node.getLeft());
            System.out.print(node.getVal()+",");
        }
    }

    @Test
    void testPrintTreePreOrderNotRecursive(){
        int[] arr = {1,2,3,4,5,6,7,8};
        printTreePreOrderNotRecursive(arr);
    }

}
