# Definition for a binary tree node.
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


from typing import Optional


class Solution:
    def addOneRow(self, root: Optional[TreeNode], val: int, depth: int) -> Optional[TreeNode]:
        if depth == 1:
            return TreeNode(val, root, None)
        current_level = [root]

        for _ in range(1, depth - 1):
            children = []
            for node in current_level:
                if node.left:
                    children.append(node.left)
                if node.right:
                    children.append(node.right)
            current_level = children

        for node in current_level:
            node.left = TreeNode(val, node.left, None)
            node.right = TreeNode(val, None, node.right)

        return root


l1 = TreeNode(2, TreeNode(3), TreeNode(1))
r1 = TreeNode(6, TreeNode(5), None)
root = TreeNode(4, l1, r1)

print(Solution().addOneRow(root, 1, 2))
