# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        ans = []
        self.recur(root, ans)
        return ans

    def recur(self, root: 'Node', ans):
        ans.append(root.val)
        for node in root.children:
            self.recur(node, ans)
