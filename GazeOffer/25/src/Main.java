public class Main {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode res = new ListNode(-1);
            ListNode cur = res;

            while(l1 != null && l2!= null){
                if(l1.val <= l2.val){
                    cur.next = new ListNode(l1.val);
                    l1 = l1.next;
                }else{
                    cur.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                cur = cur.next;
            }

            cur.next = l1 == null ? l2 : l1;

            return res.next;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
