package 两个链表的第一个公共结点;

import org.junit.jupiter.api.Test;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    //定义2个等速指针,同时分别遍历链表,这两个指针第一次相遇的节点就是要找的节点;
    //判断当前节点是否相等
    //Error:
    /*
    测试用例:
    {1,2,3},{4,5},{6,7}
    对应输出应该为:
    {6,7}
    你的输出为:
    {}
     */
    public ListNode FindFirstCommonNodeError(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != null && p2 != null) {
            if (p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    //定义2个等速指针,同时分别遍历链表,这两个指针第一次相遇的节点就是要找的节点;
    //Fix bug: 判断当前节点的下一个节点是否相等
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1.next;
        ListNode p2 = pHead2.next;
        while (p1 != null && p2 != null) {
            if (p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    //Error
    public ListNode CreateLinkedListError(int[] arr,int n){
        ListNode head = new ListNode(arr[0]);
        ListNode newNode = null;
        for (int i = 1; i < n ; i++) {
            newNode = new ListNode(arr[i]);
            head.next = newNode;
            newNode = newNode.next;
        }
        return head;
    }

    /*
    YC:
    创建链表的思路:

     */
    public ListNode CreateLinkedList(int[] arr,int n){
        ListNode head = new ListNode(arr[0]);
        ListNode curNode = head;
        for (int i = 1; i < n ; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        return head;
    }

    public void PrintLinkedList(ListNode head){
        while (head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    @Test
    public void TestCreateLinkedList(){
        int[] arr1 = {1,2,3};
        int[] arr2 = {7,8,3};
        PrintLinkedList(CreateLinkedList(arr1,arr1.length));
        System.out.println();
        PrintLinkedList(CreateLinkedList(arr2,arr2.length));

        System.out.println(FindFirstCommonNode(CreateLinkedList(arr1,arr1.length),CreateLinkedList(arr2,arr2.length)));
    }
}
