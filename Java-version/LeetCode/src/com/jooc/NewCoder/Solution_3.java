package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.ListNode;

public class Solution_3 implements Solution {
    @Override
    public void main() {

    }

    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
//    public ListNode reverseKGroup_0 (ListNode head, int k) {
//        // write code here
//
//        int len = 0;
//        ListNode cur = head;
//        while(cur != null){
//            len ++;
//            cur = cur.next;
//        }
//
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode pre = dummy;
//
//        for(int i = 0; i < len % k; i++) {
//            cur = pre;
//            for (int j = 0; j < k; j++) {
//                cur = cur.next;
//            }
//            ListNode temp = cur.next;
//
//        }
//    }

    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        ListNode tail = head;
        for (int i = 0; i < k; i++){
            if(tail == null){
                return head;
            }
            tail = tail.next;
        }

        ListNode pre = null;
        ListNode cur = head;
        while(cur != tail){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next = reverseKGroup(tail, k);
        return pre;
    }

}
