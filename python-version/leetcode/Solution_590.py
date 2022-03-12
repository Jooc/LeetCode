from typing import List
from collections import defaultdict

# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def postorder_recur(self, root: 'Node') -> List[int]:
        ans = []
        if root is None:
            return ans

        def recur(node: 'Node'):
            nonlocal ans
            for child in node.children:
                recur(child)
            ans.append(node.val)

        recur(root)
        return ans

    def postorder(self, root: 'Node') -> List[int]:
        ans = []
        if root is None:
            return ans

        stack = []
        next_index = defaultdict(int)
        node = root

        while stack or node:
            while node:
                stack.append(node)
                if not node.children:
                    break
                next_index[node] = 1
                node = node.children[0]
            node = stack[-1]
            i = next_index[node]
            if i < len(node.children):
                next_index[node] = i + 1
                node = node.children[i]
            else:
                ans.append(node.val)
                stack.pop()
                del next_index[node]
                node = None

        return ans
