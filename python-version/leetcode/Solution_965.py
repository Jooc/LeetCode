# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isUnivalTree_re(self, root: TreeNode) -> bool:
        val = root.val
        def dfs(node):
            if node is None:
                return True
            if node.val != val:
                return False
            return dfs(node.left) and dfs(node.right)

        return dfs(root)

    def isUnivalTree(self, root: TreeNode) -> bool:
        stack, val = [root], root.val
        while len(stack) > 0:
            cur = stack.pop()
            if cur.val != val:
                return False
            if cur.left is not None:
                stack.append(cur.left)
            if cur.right is not None:
                stack.append(cur.right)
        return True