package 反转链表;


import org.junit.jupiter.api.Test;

public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /*
     **不建议采用**
     思路一:  保存剩余链表,然后反转;  保存剩余链表,然后再反转  ; 重复这个动作
     注意:    头结点需要单独处理.
      */
     /*
     1. 1->2->3->null
     2. 1<-2  3->null
     3. 1<-2<-3->null
     # 文字描述过程:
     * 关键点: **由于反转后不能访问到3节点,所以在反转之前用一个nextNext节点保存3的地址**.
     * 使用三个指针的含义
     cur:当前处理的节点
     next:当前处理节点的下一个节点
     nextNext: 保存反转后的剩余链表
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head; //cur:1
        ListNode next = cur.next; //next:2
        ListNode nextNext;
        while (next != null) {//next:2  //next:3 //next:null(表示next已经是尾节点)
            nextNext = next.next;//nextNext:3  //nextNext:null   //反转前保留剩余链表的地址
            next.next = cur; //1<-2  //1<-2<-3  //反转
            if (cur == head) {//头结点单独处理
                cur.next = null;//null<-1
            }
            cur = next;//cur:2 //cur:3
            next = nextNext;//next:3  //next:null
        }
        return cur;
    }

    @Test
    public void TestReverseList() {
        ListNode oriNode = Create(new int[]{1, 2, 3, 43545, 5645}, 5);
        PrintLinkedList(oriNode);
        ListNode newNode = ReverseList(oriNode);
        PrintLinkedList(newNode);
    }

    /*
    思路2：递归.
    作者: 搁浅的鱼儿
    1. 先反转后面的链表得到pReverseHead;
    2. pHead再把
    >
    递归的方法其实是非常巧的，它利用递归走到链表的末端，然后再更新每一个node的next 值 ，实现链表的反转。
    而newhead 的值没有发生改变，为该链表的最后一个结点，所以，反转后，我们可以得到新链表的head。
     */
    public ListNode ReverseList2(ListNode pHead) {
        //如果链表为空或者链表中只有一个元素
        if (pHead == null || pHead.next == null) return pHead;
        //先反转后面的链表，走到链表的末端结点
        ListNode pReverseNode = ReverseList(pHead.next);
        //再将当前节点设置为后面节点的后续节点
        pHead.next.next = pHead;
        pHead.next = null;
        return pReverseNode;
    }


    // 思路3: //头插法反转链表
    /*
    思路很简单，每次把原链表头扯下来，安到新链表上当头
     */
    public ListNode ReverseList3(ListNode head) {
        ListNode newHead = null, temp = null; //newHead作为新链表 //temp暂存测下来的节点
        while (head != null) {
            temp = head;//扯下来
            head = head.next;//扯下来后,原链表头前移
            temp.next = newHead;//安装到新链表当头
            newHead = temp;//新链表增长(从头部增长)   //发散: 链表不只是从尾部扩展,也可以从头部扩展.
        }
        return newHead;
    }

    @Test
    public void TestReverseList2() {
        ListNode oriNode = Create(new int[]{1, 2, 3, 43545, 5645}, 5);
        PrintLinkedList(oriNode);
        ListNode newNode = ReverseList3(oriNode);
        PrintLinkedList(newNode);
    }

    //测试辅助方法
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
        System.out.println();
    }
}