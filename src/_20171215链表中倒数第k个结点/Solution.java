package _20171215�����е�����k�����;

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
  * ����һ����������������е�����k����㡣
  * @author didi
  *
  */
 
public class Solution {
	
	//�ⷨһ: ʹ��һ������������ת,�ռ临�ӶȱȽϴ�
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
    
    //�ⷨ��:ʹ��2��ָ��. �൱��һ�ѳ���Ϊk�ĳ����ƶ���ĩβ,����β�����ǵ�����k����.
    //1. pfront=pback=0, pback�ȴ�0�ߵ�k-1��
    //2. Ȼ��pback��k-1,pfront��0��ʼ,ͬ����ǰ�ƶ�,ֱ��p1����ĩβ,��ʱp2ָ��
    public static ListNode FindKthToTail2(ListNode head,int k) {
    	ListNode p,q;
    	p = q = head;
    	//1. p���ߵ�k-1��  3[1,2,3,4,5]
    	int i = 1;
     	for (; i < k; i++) {
			q = q.next;
		}
     	//2. p,qһ��ǰ��,qָ��β�ڵ�ʱ,p�ڵ���ǵ�����k���ڵ�. �൱��һ������k=3: [p,2,q]
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