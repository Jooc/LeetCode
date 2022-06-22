# Definition for a binary tree node.
from collections import deque
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def findBottomLeftValue_0(self, root: Optional[TreeNode]) -> int:
        if root.left is None and root.right is None:
            return root.val
        queue = deque()
        queue.append(root)

        last_level = []
        while len(queue) != 0:
            level = []
            while len(queue) != 0:
                root = queue.popleft()
                if root.left is not None:
                    level.append(root.left)
                if root.right is not None:
                    level.append(root.right)
            if len(level) == 0:
                return last_level[0].val

            last_level = level
            queue += level

        return -1

    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        q = deque([root])
        while q:
            cur = q.popleft()
            if cur.right:
                q.append(cur.right)
            if cur.left:
                q.append(cur.left)
            ans = cur.val

        return ans
