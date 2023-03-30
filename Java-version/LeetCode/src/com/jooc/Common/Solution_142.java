package com.jooc.Common;

import com.jooc.Solution;
import com.jooc.components.ListNode;

public class Solution_142 implements Solution {
    @Override
    public void main() {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (true) {
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null)
                return null;
            if (fast == slow)
                break;

        }
        fast = head;

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
