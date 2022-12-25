package com.jooc.components;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int x, ListNode next){
        val = x;
        this.next = next;
    }

    public ListNode(int[] lists){
        if (lists.length == 0){
            val = -1;
            next = null;
        }else {
            val = lists[0];
            ListNode pre = this;

            for (int i = 1; i < lists.length; i++) {
                pre.next = new ListNode(lists[i]);
                pre = pre.next;
            }
        }
    }

    public void printAll(int seq){
        if (seq > 100){
            return ;
        }
        System.out.print(this.val);
        System.out.print(' ');
        if (this.next != null) {
            this.next.printAll(seq + 1);
        }else{
            System.out.println();
        }
    }
}