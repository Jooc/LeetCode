from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def dfs(self, node: TreeNode, array: List):
        if node:
            self.dfs(node.left, array)
            array.append(node.val)
            self.dfs(node.right, array)

    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:
        array1, array2 = [], []
        self.dfs(root1, array1)
        self.dfs(root2, array2)

        ans = []
        i1, i2, n1, n2 = 0, 0, len(array1), len(array2)
        while i1 < n1 and i2 < n2:
            if array1[i1] <= array2[i2]:
                ans.append(array1[i1])
                i1 += 1
            else:
                ans.append(array2[i2])
                i2 += 1

        while i1 < n1:
            ans.append(array1[i1])
            i1 += 1
        while i2 < n2:
            ans.append(array2[i2])
            i2 += 1

        return ans