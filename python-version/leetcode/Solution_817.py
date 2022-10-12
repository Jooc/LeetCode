# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional, List

from Top100.Solution_2 import ListNode


class Solution:
    def numComponents(self, head: Optional[ListNode], nums: List[int]) -> int:
        count, is_counting = 0, False
        num_set = set(nums)
        while head:
            if head.val not in num_set:
                is_counting = False
            elif not is_counting:
                count += 1
                is_counting = True
            head = head.next
        return count