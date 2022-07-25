# Definition for a binary tree node.
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class CBTInserter_0:

    def __init__(self, root: TreeNode):
        self.root = root

    def insert(self, val: int) -> int:
        q = deque([self.root])

        new_node = TreeNode(val)

        recur_list = []
        while q or recur_list:
            if not q:
                q = deque(recur_list)

            node = q.popleft()

            if not node.left:
                node.left = new_node
                return node.val
            else:
                recur_list.append(node.left)

            if not node.right:
                node.right = new_node
                return node.val
            else:
                recur_list.append(node.right)

        return -1

    def get_root(self) -> TreeNode:
        return self.root


class CBTInserter_1:

    def __init__(self, root: TreeNode):
        self.root = root
        self.able_to_append = deque()

        q = deque([root])
        while q:
            node = q.popleft()
            if node.left:
                q.append(node.left)
            if node.right:
                q.append(node.right)
            if not (node.left and node.right):
                self.able_to_append.append(node)

    def insert(self, val: int) -> int:
        candidate_ = self.able_to_append

        new_node = TreeNode(val)
        node = candidate_[0]
        ret = node.val

        if not node.left:
            node.left = new_node
        else:
            node.right = new_node
            candidate_.popleft()

        candidate_.append(new_node)
        return ret

    def get_root(self) -> TreeNode:
        return self.root


class CBTInserter:
    def __init__(self, root: TreeNode):
        self.root = root
        self.cnt = 0

        q = deque([root])
        while q:
            node = q.popleft()
            self.cnt += 1
            if node.left:
                q.append(node.left)
            if node.right:
                q.append(node.right)

    def insert(self, val: int) -> int:
        self.cnt += 1

        new_node = TreeNode(val)
        node = self.root
        highbit = self.cnt.bit_length() - 1

        for i in range(highbit - 1, 0, -1):
            if self.cnt & (1 << i):
                node = node.right
            else:
                node = node.left

        if self.cnt & 1:
            node.right = new_node
        else:
            node.left = new_node

        return node.val

    def get_root(self) -> TreeNode:
        return self.root
