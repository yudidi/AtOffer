package 从上往下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 
 * @author didi
 * 
 */
class TreeNode {
	String val = "";
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode() {
	}

	public TreeNode(String val) {
		this.val = val;
	}
}

public class Demo1 {
	public static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TreeNode rootNode = new TreeNode();
		// CreateTreePreOrder(rootNode);
		ArrayList<String> list = new Demo1()
				.PrintFromTopToBottom(CreateTreePreOrder());
		System.out.println(list);
	}

	public static void CreateTreePreOrder(TreeNode root) {
		if (!reader.hasNext()) {
			return;
		}
		String input = reader.next();
		System.out.println("input is : " + input);
		if (!input.trim().equals('#')) {
			root.val = input.trim();
		} else {
			root = null;
			return;
		}
		root.left = new TreeNode();
		root.right = new TreeNode();
		CreateTreePreOrder(root.left);
		CreateTreePreOrder(root.right);
	}

	public static TreeNode CreateTreePreOrder2(TreeNode root) {
		// TreeNode root;//this variable will be distroyed after the function
		// finished, so we need pass a args to this function.
		String input = reader.next();
		System.out.println("input is : " + input);
		if (!input.trim().equals('#')) {
			root = new TreeNode(input.trim());
			root.left = CreateTreePreOrder2(root);
			root.right = CreateTreePreOrder2(root);
		} else {
			return null;
		}
		return root;
	}

	/**
	 * 根据输入流的序列,创建一个二叉树,并返回根节点的引用
	 * 
	 * @return
	 */
	public static TreeNode CreateTreePreOrder() {
		// 输入是否#
		// #则返回null节点
		// 创建一个节点,赋值
		// 创建该节点的左子树
		// 创建该节点的右子树
		// 返回这个新节点
		if (!reader.hasNext()) {
			return null;
		}
		TreeNode root;
		String input = reader.next();
		System.out.println("input is : " + input);
		if (input.trim().equals('#')) {
			return null;
		} else {

			root = new TreeNode(input.trim());
		}
		root.left = CreateTreePreOrder();
		root.right = CreateTreePreOrder();
		return root;
	}

	public ArrayList<String> PrintFromTopToBottom(TreeNode root) {
		ArrayList<String> list = new ArrayList<String>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode treeNode = queue.poll();
			if (treeNode.left != null) {
				queue.offer(treeNode.left);
			}
			if (treeNode.right != null) {
				queue.offer(treeNode.right);
			}
			list.add(treeNode.val);
		}
		return list;
	}

	public ArrayList<String> PrintFromTopToBottom2(TreeNode root) {
		if (root == null)
			return null;
		ArrayList<String> list = new ArrayList<String>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode output = queue.remove();
			list.add(output.val);
			if (output.left != null) {
				queue.add(output.left);
			}
			if (output.right != null) {
				queue.add(output.right);
			}
		}
		return list;
	}
}
