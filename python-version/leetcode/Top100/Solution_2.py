# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        ans = ListNode(-1)
        cur = ans

        carry = 0
        while l1 is not None or l2 is not None or carry:
            n1 = l1.val if l1 else 0
            n2 = l2.val if l2 else 0
            single_sum, carry = divmod(n1 + n2 + carry, 10)
            cur.next = ListNode(single_sum)
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
            cur = cur.next

        return ans.next

    # def get_sum_with_carry(self, sum):
    #     return sum % 10, 1 if sum >= 10 else 0