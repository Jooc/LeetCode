package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.ListNode;

public class Solution_15 implements Solution {

    @Override
    public void main() {
        ListNode root = new ListNode(new int[]{1,1,1});
        deleteDuplicates(root).printAll(0);
    }

    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates_0(ListNode head) {
        // write code here
        if (head == null || head.next == null) return head;

        ListNode cur = head;
        while (cur != null) {
            ListNode nextNode = cur.next;
            if (nextNode != null && cur.val == nextNode.val) {
                cur.next = nextNode.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null) return head;

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }
}
