package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.ListNode;

import java.util.Stack;

public class Solution_13 implements Solution {
    public void main(){
        ListNode root = new ListNode(new int[]{1,2,3,2,1});
        System.out.println(isPail(root));
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
    public boolean isPail (ListNode head) {
        if (head.next == null)
            return true;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while(slow != null){
            if (slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
