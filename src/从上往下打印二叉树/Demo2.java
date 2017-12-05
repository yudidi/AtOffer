package 从上往下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * notice: 1. 输入序列的要求: input sequences中,每个叶子节点都应该是"#". YC: 不必是满二叉树数或完全二叉树.
 * 
 * @author didi
 * 
 */
public class Demo2 {
	public static Scanner reader;

	public static void main(String[] args) {
		createBiTree();
	}

	public static void createBiTree() {
		reader = new Scanner(System.in); // 前序序列: 1 2 4 # # # 3 # #  // 1 2 4 # # # 5 # # //1 2 4 # # # 8 # #
		TreeNode root = null;
		root = CreateTreePreOrder(root);
		System.out.println(PrintFromTopToBottom(root));
		root = CreateTreePreOrder2();
		System.out.println(PrintFromTopToBottom(root));
		root = CreateTreePreOrder(root);
		System.out.println(PrintFromTopToBottom(root));
	}

	public static TreeNode CreateTreePreOrder(TreeNode root) {
		if (!reader.hasNext()) {
			return null;
		}
		String input = reader.next();
		System.out.println("input is :" + input);
		if (input.trim().equals("#")) {
			return null;
		} else {
			root = new TreeNode(input.trim());
			root.left = CreateTreePreOrder(root.left);
			root.right = CreateTreePreOrder(root.right);
		}
		return root;
	}

	public static TreeNode CreateTreePreOrder2() {
		if (!reader.hasNext()) {
			return null;
		}
		TreeNode root;
		String input = reader.next();
		System.out.println("input is :" + input);
		if (input.trim().equals("#")) {
			return null;
		} else {
			root = new TreeNode(input.trim());
			root.left = CreateTreePreOrder2();
			root.right = CreateTreePreOrder2();
		}
		return root;
	}

	public static ArrayList<String> PrintFromTopToBottom(TreeNode root) {
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

}
