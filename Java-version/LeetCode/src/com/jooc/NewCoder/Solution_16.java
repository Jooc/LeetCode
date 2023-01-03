package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.ListNode;

public class Solution_16 implements Solution {
    @Override
    public void main() {
        ListNode root = new ListNode(new int[]{1,2,2});
        deleteDuplicates(root).printAll(0);
    }

    /**
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates_0 (ListNode head) {
        // write code here

        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        ListNode resCur = dummy;

        while(cur != null){
            if (cur.next != null && cur.val == cur.next.val){
                int abandonedVal = cur.val;
                while(cur != null && cur.val == abandonedVal){
                    cur = cur.next;
                }
            }else{
                resCur.next = new ListNode(cur.val);
                resCur = resCur.next;
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;

        while(cur.next != null && cur.next.next != null){
            if (cur.next.val == cur.next.next.val){
                int abandonedVal = cur.next.val;
                while(cur.next != null && cur.next.val == abandonedVal)
                    cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
