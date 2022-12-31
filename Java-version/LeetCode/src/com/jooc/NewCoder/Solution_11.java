package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.ListNode;

public class Solution_11 implements Solution {
    public void main(){

    }

    /**
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     *
     * Cannot handle big num
     */
    public ListNode addInList_0 (ListNode head1, ListNode head2) {
        // write code here
        int num1 = 0, num2 = 0;
        while(head1 != null) {
            num1 = num1 * 10 + head1.val;
            head1 = head1.next;
        }
        while(head2 != null) {
            num2 = num2 * 10 + head2.val;
            head2 = head2.next;
        }
        num1 += num2;
        ListNode dummy = new ListNode(-1);
        while(num1 != 0){
            head2 = new ListNode(num1 % 10);
            head2.next = dummy.next;
            dummy.next = head2;
            num1 /= 10;
        }
        return dummy.next;
    }

    private ListNode ReverseList(ListNode head) {
        ListNode newHead = null;

        while (head != null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    /**
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;

        head1 = ReverseList(head1);
        head2 = ReverseList(head2);

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        int plusFlag = 0;
        while(head1 != null || head2 != null){
            int newVal = plusFlag;
            if (head1 != null){
                newVal += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                newVal += head2.val;
                head2 = head2.next;
            }
            current.next = new ListNode(newVal % 10);
            plusFlag = newVal / 10;
            current = current.next;
        }

        return ReverseList(dummy.next);
    }
}
