package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.ListNode;

import java.util.Stack;

public class Solution_1 implements Solution {


    @Override
    public void main() {
        ListNode tail = new ListNode(3);
        ListNode sec = new ListNode(2);
        sec.next = tail;
        ListNode root = new ListNode(1);
        root.next = sec;

        this.ReverseList(root).printAll();
    }

//    Based on Stack
    public ListNode ReverseList_0(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()){
            return null;
        }
        ListNode curNode = stack.pop();
        ListNode dummy = curNode;

        while (!stack.isEmpty()){
            curNode.next = stack.pop();
            curNode = curNode.next;
        }
        curNode.next = null;
        return dummy;
    }

//    new List
    public ListNode ReverseList_1(ListNode head) {
        ListNode dummy = new ListNode(-1);

        while (head != null){
            ListNode currentNode = head;
            head = head.next;

            currentNode.next =dummy.next;
            dummy.next = currentNode;
        }
        return dummy.next;
    }

    public ListNode ReverseList(ListNode head) {
        ListNode newHead = null;

        while (head != null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    public ListNode ReverseList_Recursive(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode next = head.next;
        ListNode reverse = ReverseList(next);
        next.next = head;
        head.next = null;

        return reverse;
    }

    public ListNode ReverseList_TailRecursive(ListNode head) {
        return reverseListInt(head, null);
    }
    private ListNode reverseListInt(ListNode head, ListNode newHead){
        if (head==null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next,head);
    }
}
