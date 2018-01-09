package _0链表;

import org.junit.jupiter.api.Test;

/**
 * Created by didi on 09/01/2018.
 */
public class CreateLinkedList {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Create(int[] arr, int n) {
        if (n == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public void PrintLinkedList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(" " + cur.val);
            cur = cur.next;
        }
    }

    @Test
    public void TestCreateLInkedList() {
        int[] arr = {1, 2, 3, 4, 5};
        PrintLinkedList(Create(arr, arr.length));
        arr = new int[]{1, 2, 3, 4, 8};
        System.out.println();
        PrintLinkedList(Create(arr, arr.length));
    }

}
