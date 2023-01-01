package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.ListNode;

import java.util.*;

public class Solution_12 implements Solution {
    public void main() {
        ListNode root = new ListNode(new int[]{3,2,4,6,5,1,7,8});
        sortInList(root).printAll(0);
    }

    /**
     * @param head ListNode类 the head node
     * @return ListNode类
     * <p>
     * Need to use the big heap
     */
    public ListNode sortInList_0(ListNode head) {
        // write code here
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        while (head != null) {
            queue.offer(head);
            head = head.next;
        }

        ListNode dummy = new ListNode(-1);
        head = dummy;
        while (!queue.isEmpty()) {
            head.next = queue.poll();
            head = head.next;
            head.next = null;
        }
        return dummy.next;
    }

    public ListNode sortInList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = sortInList(head);
        ListNode right = sortInList(temp);

        ListNode dummy = new ListNode(-1);
        head = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val){
                head.next = left;
                left = left.next;
            }else{
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        if (left != null){
            head.next = left;
        }
        if (right != null){
            head.next = right;
        }
        return dummy.next;
    }
}
