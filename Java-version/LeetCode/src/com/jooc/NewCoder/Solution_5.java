package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_5 implements Solution {

    @Override
    public void main() {
        ListNode r1 = new ListNode(new int[]{1, 2, 3});
        r1.printAll(0);
        ListNode r2 = new ListNode(new int[]{4, 5, 6, 7});
        r2.printAll(0);

        System.out.println();

        ListNode[] lists = new ListNode[]{r1, r2};
        this.mergeKLists(new ArrayList<ListNode>(List.of(lists))).printAll(0);
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        Queue<ListNode> queue = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);

        for(ListNode head: lists){
            if (head != null)
                queue.add(head);
        }

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;

        while (!queue.isEmpty()) {
            ListNode head = queue.poll();
            pre.next = head;
            if(head.next != null) {
                queue.add(head.next);
            }
            pre = pre.next;

            dummy.printAll(0);
        }
        return dummy.next;
    }
}
