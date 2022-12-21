# Definition for a binary tree node.
from typing import Optional, List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> Optional[TreeNode]:
        def recur(start, end) -> Optional[TreeNode]:
            if start > end:
                return None

            max_index = start
            for i in range(start+1, end + 1):
                if nums[i] > nums[max_index]:
                    max_index = i

            node = TreeNode(nums[max_index])
            node.left = recur(start, max_index - 1)
            node.right = recur(max_index + 1, end)

            return node

        return recur(0, len(nums) - 1)

soultion = Solution()
soultion.constructMaximumBinaryTree([3,2,1,6,0,5])