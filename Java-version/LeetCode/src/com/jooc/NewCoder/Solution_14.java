package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.ListNode;

public class Solution_14 implements Solution {
    @Override
    public void main() {
        ListNode root = new ListNode(new int[]{1, 2, 3, 4, 5, 6});
        oddEvenList(root).printAll(0);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList_0(ListNode head) {
        // write code here
        if (head == null || head.next == null)
            return head;

        ListNode curOdd = head, curEven = head.next;
        ListNode cur = head.next.next;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = curOdd.next;
            curOdd.next = cur;
            curOdd = curOdd.next;

            cur = tmp;
            if (cur == null) break;

            tmp = cur.next;
            cur.next = null;
            curEven.next = cur;
            curEven = curEven.next;

            cur = tmp;
        }

        return head;
    }

    public ListNode oddEvenList(ListNode head) {
        // write code here
        if (head == null)
            return null;

        ListNode odd = head, even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
