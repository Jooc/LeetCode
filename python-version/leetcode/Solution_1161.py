from collections import deque
from math import inf
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        ans, max_sum = 1, root.val
        level, q = 1, [root]

        while q:
            level_sum = 0
            next_level = []

            for node in q:
                level_sum+= node.val
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)

            if level_sum > max_sum:
                ans = level
                max_sum = level_sum
            level += 1
            q = next_level

        return ans


root = TreeNode(1)
l = TreeNode(7)
r = TreeNode(0, TreeNode(7), TreeNode(-8))
root.left = l
root.right = r

print(Solution().maxLevelSum(root))
