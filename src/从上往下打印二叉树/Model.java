package 从上往下打印二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class MyTreeNode{
	String data;
	MyTreeNode lChild;
	MyTreeNode rClild;
	public MyTreeNode(){
	}
}

/**
 * 知识体系:
 * https://www.processon.com/mindmap/5a261881e4b0dce08035bce9
 * @author didi
 *
 */

public class Model {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//create tree
		MyTreeNode root = null;
		 root = createMyTreeNode(root, scanner);//注意要返回,这样才能保证变量存放根节点的地址.
		 // 1 2 3 # # # #
		 // 1 2 # # 3 # # 
		 // 1 2 3 # # 4 # # 5 # #
		//printTreeFromTopToBottom;
		printTreeFromTopToBottom(root);
	}
	
	//input sequence is preorder.
	static MyTreeNode createMyTreeNode(MyTreeNode root,Scanner scanner){
		//create node by input data;
		//create the lClild and rChild of the new node.
		//return the root node.
		if (!scanner.hasNext()) {
			return null;
		}
		String input = scanner.next();
		if (input.trim().equals("#")) {
			return null;//# means empty node.
		}else {
			root = new MyTreeNode();
			root.data = input;
			root.lChild = createMyTreeNode(root.lChild, scanner);
			root.rClild = createMyTreeNode(root.rClild,scanner);
		}
		return root;
	}
	
	//层次遍历和其他遍历的不同,就是思路描述中不存在"子树"这样的概念,不能使用递归.
	static void printTreeFromTopToBottom(MyTreeNode root){
		if (root == null) {
			return;
		}
		Queue<MyTreeNode> container = new LinkedList<MyTreeNode>();
		container.add(root);
		while (!container.isEmpty()) {
			MyTreeNode output = container.remove();
			System.out.println(output.data);
			if (output.lChild != null) {
				container.add(output.lChild);
			}
			if (output.rClild != null) {
				container.add(output.rClild);
			}
		}
	}
	
}
