package com.jooc.GazeOffer;

import com.jooc.components.ListNode;

public class Solution_24 {

    public ListNode reverseList(ListNode head) {
        ListNode res = null, cur = null;

        while (head != null) {
            res = new ListNode(head.val);
            res.next = cur;
            cur = res;
        }

        return res;
    }
}
