# Definition for a binary tree node.
from math import inf


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:
    def serialize(self, root: TreeNode) -> str:
        """Encodes a tree to a single string.
        """
        res = []
        def post_order(node: TreeNode):
            if node is None:
                return
            post_order(node.left)
            post_order(node.right)
            res.append(node.val)
        post_order(root)
        return ' '.join(map(str, res))

    def deserialize(self, data: str) -> TreeNode:
        """Decodes your encoded data to tree.
        """
        print(data.split())
        post_order = list(map(int, data.split()))
        def construct(lower, upper) -> TreeNode:
            if post_order == [] or post_order[-1] < lower or post_order[-1] > upper:
                return None
            val = post_order.pop()
            root = TreeNode(val)
            root.right = construct(val, upper)
            root.left = construct(lower, val)
            print(post_order)
            return root
        return construct(-inf, inf)

a = [1, 2, 4, 5]
a1 = '-'.join(map(str, a))
print(a1)
a2 = a1.split()
print(a2)
a3 = list(map(int, a2))
print(a3)



# Your Codec object will be instantiated and called as such:
# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# tree = ser.serialize(root)
# ans = deser.deserialize(tree)
# return ans