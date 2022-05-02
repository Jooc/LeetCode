# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


from typing import List
from collections import deque


class Solution:
    def main(self):
        # root = [1,null,3,2,4,null,5,6]
        node5 = Node(5)
        node6 = Node(6)
        node3 = Node(3, [node5, node6])
        node2 = Node(2)
        node4 = Node(4)
        root = Node(1, [node3, node2, node4])

        print(self.levelOrder(root))

    def levelOrder_0(self, root: 'Node') -> List[List[int]]:
        if root is None:
            return []
        if len(root.children) == 0:
            return [[root.val]]

        ans, level = [], []
        q = deque()
        last = root
        q.append(root)

        node = None
        next_level = []
        while len(q) != 0:
            node = q.popleft()
            level.append(node.val)

            if node.children is not None:
                for child in node.children:
                    next_level.append(child)

            if node == last:
                ans.append(level)
                level = []
                if len(next_level) > 0:
                    last = next_level[-1]
                    q = deque(next_level)
                    next_level = []

        return ans

    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:
            return []

        ans = []
        q = deque([root])

        while q:
            counter = len(q)
            level = []

            for _ in range(counter):
                current = q.popleft()
                level.append(current.val)
                for child in current.children:
                    q.append(child)
            ans.append(level)

        return ans