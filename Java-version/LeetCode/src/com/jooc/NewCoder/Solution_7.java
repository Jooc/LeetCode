package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_7 implements Solution {

    @Override
    public void main() {

    }

    public ListNode EntryNodeOfLoop_0(ListNode pHead) {
        List<Integer> memory = new ArrayList<>();

        while (pHead != null){
            if (memory.contains(pHead.val))
                return pHead;
            memory.add(pHead.val);
            pHead = pHead.next;
        }

        return null;
    }

    private ListNode hasCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                return slow;
        }
        return null;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = hasCycle(pHead);

        if(slow == null)
            return null;

        ListNode fast = pHead;
        while(fast != slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
