from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def findFrequentTreeSum(self, root: TreeNode) -> List[int]:
        counter = dict()

        def recur(root: TreeNode):
            if root is None:
                return 0

            nonlocal counter
            s = root.val + recur(root.left) + recur(root.right)
            if s not in counter.keys():
                counter[s] = 1
            else:
                counter[s] += 1

            return s

        recur(root)

        max_val = max(counter.values())
        return [key for key, val in enumerate(counter) if val == max_val]

