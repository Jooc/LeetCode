package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.ListNode;

import java.util.Stack;

public class Solution_8 implements Solution {
    public void main(){

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     * T = O(n); S = O(n)
     */
    public ListNode FindKthToTail_0 (ListNode pHead, int k) {
        // write code here

        Stack<ListNode> stack = new Stack<>();
        while(pHead != null){
            stack.push(pHead);
            pHead = pHead.next;
        }

        if ((stack.size()) < k)
            return null;

        for(int i = 0; i < k; i++){
            pHead = stack.pop();
        }
        return pHead;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     * T = O(n); S = O(1)
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here

        ListNode fast = pHead;
        for(int i = 0; i < k; i++) {
            if (fast == null)
                return null;
            fast = fast.next;
        }
        ListNode slow = pHead;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
