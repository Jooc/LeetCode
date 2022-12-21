package com.jooc.components;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public void printAll(){
        System.out.print(this.val);
        System.out.print(' ');
        if (this.next != null) {
            this.next.printAll();
        }
    }
}
