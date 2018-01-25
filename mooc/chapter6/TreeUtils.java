package chapter6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TreeUtils {

    //传入数组,创建二叉树
    public static TreeNode createTree(int[] arr, int n) {
        //创建所有节点
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new TreeNode(arr[i]));
        }
        //连接所有节点,形成树的结构.
        for (int i = 0; i <= (n - 1) / 2; i++) {
            if (2 * i + 1 <= n - 1) {
                list.get(i).left = list.get(2 * i + 1);
            }
            if (2 * i + 2 <= n - 1) {
                list.get(i).right = list.get(2 * i + 2);
            }
        }
        return list.get(0);
    }

    //打印二叉树
    public void printTreePreOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val+",");
            printTreePreOrder(root.left);
            printTreePreOrder(root.right);
        }
    }

    //传入数组,创建二叉树
    public TreeNode createTree2(int[] arr, int n) {
        return createTree22(arr,n,0);
    }

    private TreeNode createTree22(int[] arr, int n, int cur) {
        TreeNode root = new TreeNode(arr[cur]);
        if (2 * cur + 1 < n) {
            root.left = createTree22(arr, n, 2 * cur + 1);
        }
        if (2 * cur + 2 < n) {
            root.right = createTree22(arr, n, 2 * cur + 2);
        }
        return root;
    }

    //根据前序输入序列,创建二叉树
    public TreeNode createTree3ByPreInput(String preInput){
        return null;
    }


    @Test
    void testCreateTree() {
        int[] arr = {1, 2, 3, 4, 5};
        TreeNode root = createTree(arr, arr.length);
        printTreePreOrder(root);
        System.out.println();
    }

    @Test
    void testCreateTree2() {
        int[] arr = {1, 2, 3, 4, 5};
        TreeNode root = createTree2(arr, arr.length);
        printTreePreOrder(root);
        System.out.println();
    }
}
