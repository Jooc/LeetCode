import com.jooc.Solution;
import com.jooc.components.ListNode;

public class Solution_4 implements Solution {
    @Override
    public void main() {

    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;

        while(list1 != null && list2 != null){
            if (list1.val <= list2.val) {
                pre.next = list1;
                list1 = list1.next;
            }else{
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        if (list1 != null){
            pre.next = list1;
        }else{
            pre.next = list2;
        }

        return dummy.next;
    }
}
