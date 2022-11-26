from typing import Optional, List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution_0:
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        record = {}
        stack = [root]
        res = set()

        while stack:
            node = stack.pop()

            if node.val in record.keys() and self.judge_duplicate(node, record[node.val]):
                res.add(node)
            else:
                record[node.val] = node

            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)

        return list(res)

    def judge_duplicate(self, root1, root2):
        stack1, stack2 = [root1], [root2]
        while stack1 and stack2:
            node1, node2 = stack1.pop(), stack2.pop()
            if node1.val != node2.val:
                return False
            if node1.left and node2.left:
                stack1.append(node1.left)
                stack2.append(node2.left)
            if node1.right and node2.right:
                stack1.append(node1.right)
                stack2.append(node2.right)

        return True

class Solution:
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        def dfs(node: Optional[TreeNode]) -> str:
            if not node:
                return ""

            serial = "".join([str(node.val), '(', dfs(node.left), ')(', dfs(node.right), ')'])
            if tree := seen.get(serial):
                repeat.add(tree)
            else:
                seen[serial] = node
            return serial

        seen = dict()
        repeat = set()

        dfs(root)
        return list(repeat)




