package com.jooc.GazeOffer;

import com.jooc.Solution;
import com.jooc.components.ListNode;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution_6 implements Solution {
    @Override
    public void main() {
        Solution solution = new Solution();

        ListNode target = new ListNode(1);
        ListNode target2 = new ListNode(3);
        ListNode target3 = new ListNode(2);

        target.next = target2;
        target2.next = target3;

        System.out.println(Arrays.toString(solution.reversePrint(target)));
    }

    class Solution {
        public int[] reversePrint(ListNode head) {
            LinkedList<Integer> stack = new LinkedList<Integer>();

            while(head != null){
                stack.push(head.val);
                head = head.next;
            }

            int[] ans = new int[stack.size()];
            int index = 0;
            while(!stack.isEmpty()){
                ans[index++] = stack.pop();
            }

            return ans;
        }
    }
}
