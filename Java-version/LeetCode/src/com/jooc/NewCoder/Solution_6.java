package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution_6 implements Solution {
    @Override
    public void main(){

    }

    public boolean hasCycle_0(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null){
            if (set.contains(head))
                return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                return true;
        }
        return false;
    }
}
