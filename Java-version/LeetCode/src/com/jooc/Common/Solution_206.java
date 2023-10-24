package com.jooc.Common;

import com.jooc.Solution;
import com.jooc.components.ListNode;

public class Solution_206 implements Solution {
    @Override
    public void main() {
        ListNode target = new ListNode(1);
        ListNode target1 = new ListNode(2);
        ListNode target2 = new ListNode(3);
        ListNode target3 = new ListNode(4);

        target3.next = new ListNode(5);
        target2.next = target3;
        target1.next = target2;
        target.next = target1;
        reverseList(target).printAll(0);
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
