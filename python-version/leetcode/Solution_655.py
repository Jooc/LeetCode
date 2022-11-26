from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def printTree(self, root: Optional[TreeNode]) -> List[List[str]]:
        def cal_depth(node):
            return max(cal_depth(node.left) + 1 if node.left else 0, cal_depth(node.right) + 1 if node.right else 0)

        height = cal_depth(root)
        row = height + 1
        col = 2 ** row - 1
        res = [[''] * col for _ in range(row)]

        def dfs(node, r, c):
            res[r][c] = str(node.val)
            if node.left:
                dfs(node.left, r + 1, c - 2 ** (height - r - 1))
            if node.right:
                dfs(node.right, r + 1, c + 2 ** (height - r - 1))

        dfs(root, 0, (col - 1) // 2)
        return res


r = TreeNode(1, TreeNode(2))

solution = Solution()
print(solution.printTree(r))
