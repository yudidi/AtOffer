package _20171215链表中倒数第k个结点;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
 
 /**
  * 输入一个链表，输出该链表中倒数第k个结点。
  * @author didi
  *
  */
 
public class Solution {
	
	//解法一: 使用一个有序容器中转,空间复杂度比较大
    public static ListNode FindKthToTail(ListNode head,int k) {
    	if (head == null || k <=0) {
			return null;
		}
    	
    	List<ListNode> tmp = new ArrayList<>();
    	while (head != null) {
			tmp.add(head);
			head = head.next;
		}
    	
    	if (k>tmp.size()) {
			return null;
		}
    	return tmp.get(tmp.size()-k);
    }
    
    //解法二:使用2个指针. 相当于一把长度为k的尺子移动到末尾,尺子尾部就是倒数第k个数.
    //1. pfront=pback=0, pback先从0走到k-1处
    //2. 然后pback从k-1,pfront从0开始,同步往前移动,直到p1到达末尾,此时p2指向
    public static ListNode FindKthToTail2(ListNode head,int k) {
    	ListNode p,q;
    	p = q = head;
    	//1. p先走到k-1处  3[1,2,3,4,5]
    	int i = 1;
     	for (; i < k; i++) {
			q = q.next;
		}
     	//2. p,q一起前移,q指向尾节点时,p节点就是倒数第k个节点. 相当于一个尺子k=3: [p,2,q]
     	for (i = k; q.next!=null; i++) {//YC: [q.next != null] ; [q != null]
			q = q.next;
			p = p.next;
		}
    	return k<=i ? p : null;
    }
    
    
    
    public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		System.out.println(FindKthToTail(head, 3).val);
		System.out.println(FindKthToTail(head, 4).val);
		System.out.println(FindKthToTail(head, 5).val);
    

		System.out.println(FindKthToTail2(head, 3).val);
		System.out.println(FindKthToTail2(head, 4).val);
		System.out.println(FindKthToTail2(head, 5).val);
    
    }
    
    
}