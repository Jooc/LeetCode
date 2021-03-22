import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
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

    public static void main(String[] args) {
        Solution solution = new Main(). new Solution();

        ListNode target = new Main().new ListNode(1);
        ListNode target2 = new Main().new ListNode(3);
        ListNode target3 = new Main().new ListNode(2);

        target.next = target2;
        target2.next = target3;

        System.out.println(Arrays.toString(solution.reversePrint(target)));
    }
}
