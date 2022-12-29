package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.ListNode;

public class Solution_9 implements Solution {
    public void main(){
        ListNode root = new ListNode(new int[]{1,2});
        removeNthFromEnd(root, 2).printAll(0);
    }

    private ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here

        ListNode fast = pHead;
        for(int i = 0; i < k; i++) {
            if (fast == null)
                return null;
            fast = fast.next;
        }
        ListNode slow = pHead;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     *
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd_0 (ListNode head, int n) {
        // write code here

        ListNode pre = FindKthToTail(head,n+1);
        if(pre == null)
            return head.next;
        pre.next = pre.next.next;

        return head;
    }

    /**
     *
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = FindKthToTail(dummy,n+1);

        // Question description give the words that n is available.
        assert pre != null;
        pre.next = pre.next.next;

        return head;
    }
}
