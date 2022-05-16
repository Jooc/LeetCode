# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def main(self):
        root = TreeNode(2)
        r = TreeNode(3)
        root.right = r
        print(self.inorderSuccessor(root, root).val)

    def inorderSuccessor_0(self, root: TreeNode, p: TreeNode) -> TreeNode:
        sorted_arr = []

        def in_order(node: TreeNode):
            nonlocal sorted_arr
            if node is None:
                return
            in_order(node.left)
            sorted_arr.append(node.val)
            in_order(node.right)

        in_order(root)
        target_index = sorted_arr.index(p.val) + 1
        if target_index >= len(sorted_arr):
            return None
        target = sorted_arr[target_index]

        def search(node: TreeNode) -> TreeNode:
            if node is None:
                return None
            if target == node.val:
                return node
            elif target < node.val:
                return search(node.left)
            else:
                return search(node.right)

        return search(root)

    def inorderSuccessor_1(self, root: TreeNode, p: TreeNode) -> TreeNode:
        if root is None:
            return None
        if root.val <= p.val:
            return self.inorderSuccessor_1(root.right, p)
        ans = self.inorderSuccessor_1(root.left, p)
        return root if ans == None else ans

    def inorderSuccessor(self, root: TreeNode, p: TreeNode) -> TreeNode:
        stack, pre, cur = [], None, root
        while stack or cur:
            while cur:
                stack.append(cur)
                cur = cur.left
            cur = stack.pop()
            if pre == p:
                return cur
            pre = cur
            cur = cur.right
        return None


solution = Solution()
solution.main()
