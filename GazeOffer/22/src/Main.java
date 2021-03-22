public class Main {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    class Solution {
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

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
