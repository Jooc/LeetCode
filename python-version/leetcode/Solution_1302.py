from collections import deque
from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def deepestLeavesSum_0(self, root: Optional[TreeNode]) -> int:
        level = [root]
        while level:
            temp_level = []
            for node in level:
                if node.left:
                    temp_level.append(node.left)
                if node.right:
                    temp_level.append(node.right)
            if not temp_level:
                break
            level = temp_level

        return sum(level)

    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
        q = deque([root])
        while q:
            ans = 0
            for _ in range(len(q)):
                node = q.popleft()
                ans += node.val
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
        return ans


