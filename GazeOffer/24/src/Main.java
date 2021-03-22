public class Main {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode res = null, cur = null;

            while(head != null){
                res = new ListNode(head.val);
                res.next = cur;
                cur = res;
            }

            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
