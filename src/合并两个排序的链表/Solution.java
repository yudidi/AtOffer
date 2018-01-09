package 合并两个排序的链表;

/*
递归和非递归的思路.
https://www.cnblogs.com/zywu/p/5771306.html
 */
public class Solution {

 public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    /*
    思路:
    1. 新建一个新的链表list3, 然后逐个比较链表的头结点,把头结点小的放入新链表list3中,
    2. 对两个链表的剩余部分重复这个过程,直到比较到一个链表的尾节点.
    3. 如果链表一长一短,那么较长链表的剩余部分直接接在新链表后面.

     */
    public ListNode Merge(ListNode list1,ListNode list2) {
            return null;
    }


}