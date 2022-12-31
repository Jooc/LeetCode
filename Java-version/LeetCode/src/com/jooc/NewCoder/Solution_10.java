package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.ListNode;

public class Solution_10 implements Solution {

    public void main() {


    }

    public ListNode FindFirstCommonNode_0(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;

        while(l1 != l2){
            if (l1 == null)
                l1 = pHead2;
            else
                l1 = l1.next;

            if (l2 == null)
                l2=pHead1;
            else
                l2 = l2.next;
        }
        return l1;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;

        while(l1 != l2){
            l1 = (l1 == null)? pHead2: l1.next;
            l2 = (l2 == null)? pHead1: l2.next;
        }
        return l1;
    }
}
