package 链表中环的入口结点;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        Set<ListNode> sets = new HashSet<>();
        while (pHead != null){
            sets.add(pHead);
            if (sets.contains(pHead.next)){
                return  pHead.next;
            }
            pHead = pHead.next;
        }
        return null;
    }
}