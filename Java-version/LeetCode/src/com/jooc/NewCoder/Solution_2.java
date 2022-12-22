package com.jooc.NewCoder;

import java.util.*;

import com.jooc.Solution;
import com.jooc.components.ListNode;

public class Solution_2 implements Solution {
    @Override
    public void main() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n4.next = new ListNode(5);
        n3.next = n4;
//        n2.next = n3;
        n1.next = n2;

        this.reverseBetween_0(n1, 1, 2).printAll(0);
    }

    /**
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween_0(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        Stack<ListNode> stack = new Stack<>();
        for (int i = 1; i < m-1; i++) {
            head = head.next;
        }
        for (int i = m; i <= n; i++) {
            if (head.next != null)
                stack.push(head.next);
            if (!stack.isEmpty())
                head.next = stack.peek().next;
        }

        while(!stack.isEmpty()){
            ListNode nextNode = stack.pop();
            nextNode.next = head.next;
            head.next = nextNode;
            head = head.next;
        }

        return dummy.next;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        for (int i = 1; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }

        for (int i = m; i < n; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }
}
