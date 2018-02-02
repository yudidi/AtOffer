package test.utils;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TreeUtils {

    //传入数组,创建二叉树  //思路: 先创建所有节点,然后连接所有节点.
    public static TreeNode createTree(int[] arr, int n) {
        //创建所有节点
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new TreeNode(arr[i]));
        }
        //设置每个非叶子的孩子节点,形成树的结构.
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
    public static void printTreePreOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + ",");
            printTreePreOrder(root.left);
            printTreePreOrder(root.right);
        }
    }

    //传入数组,创建二叉树 //思路: 创建一个节点,同时设置左右孩子.
    public TreeNode createTree2(int[] arr, int n) {
        return createTree22(arr, n, 0);
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

    /*
     //TODO
    前两种创建方法,不能创建[1,2(r)],只能创建[1,2(l)].
     */
    //第一种: 扩展前序输入序列,创建二叉树
    public static TreeNode createTree3ByPreInput(String preInput) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : preInput.toCharArray()) {
            queue.add(c);
        }
        TreeNode root = createTree3ByPerInput(queue);
        return root;
    }

    private static TreeNode createTree3ByPerInput(Queue<Character> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        char c = queue.poll();
        if (c == '#') {
            return null;
        }
        TreeNode node = new TreeNode(c);
        node.left = createTree3ByPerInput(queue);
        node.right = createTree3ByPerInput(queue);
        return node;
    }

    //第二种:扩展前序序列,创建二叉树
    public static int count = 0; //count: 当前需要创建的节点的val值.
    public static TreeNode createTree3ByPreInput2(char[] preInput) {
        char c = preInput[count++];
        if (c == '#') {
            return null;
        }
        TreeNode root = new TreeNode(c);
        root.left = createTree3ByPreInput2(preInput);
        root.right = createTree3ByPreInput2(preInput);
        return root;
    }

    //中序序列,创建二叉树
    public static TreeNode createTree3ByMiddleInput(char[] preInput) {
        char c = preInput[count++];
        if (c == '#') {
            return null;
        }
        TreeNode root = new TreeNode(c);
        root.left = createTree3ByPreInput2(preInput);
        root.right = createTree3ByPreInput2(preInput);
        return root;
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

    //功能性测试
    @Test
    void testCreateTree3ByPreInput() {
        String preInput = "12##3##";
        TreeNode root = createTree3ByPreInput(preInput);
        printTreePreOrder(root);
        System.out.println();
    }

    @Test
    void testCreateTree3ByPreInput1() {
        String preInput = "ABC##DE##F##G##";
        TreeNode root = createTree3ByPreInput(preInput);
        printTreePreOrder(root);
        System.out.println();
    }

    @Test
    void testCreateTree3ByPreInput2() {
        String preInput = "12##3##";
        TreeNode root = createTree3ByPreInput2(preInput.toCharArray());
        printTreePreOrder(root);
        System.out.println();
    }

    @Test
    void testCreateTree3ByPreInput21() {
        String preInput = "ABC##DE##F##G##";
        TreeNode root = createTree3ByPreInput2(preInput.toCharArray());
        printTreePreOrder(root);
        System.out.println();
    }
}
