package com.jooc.GazeOffer;

import com.jooc.components.ListNode;

public class Solution_22  {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode before = head;
        ListNode later = head;

        for(int i = 0; i < k; i++){
            later = later.next;
        }

        while(later != null){
            before = before.next;
            later = later.next;
        }

        return before;
    }
}
