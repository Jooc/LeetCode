# Definition for a QuadTree node.
class Node:
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight


from typing import List


class Solution:
    def main(self):
        print(self.construct([[0, 1], [1, 0]]))

    def is_leaf(self, tl, br) -> bool:
        flag = self.grid[tl[0]][tl[1]]
        for row in range(tl[0], br[0]):
            for col in range(tl[1], br[1]):
                if self.grid[row][col] != flag:
                    return False
        return True

    def dfs(self, tl: List[int], br: List[int]) -> 'Node':
        n = br[0] - tl[0]
        if self.is_leaf(tl, br):
            return Node(bool(self.grid[tl[0]][tl[1]]), True, None, None, None, None)
        else:
            return Node(False, False,
                        self.dfs(tl, [tl[0] + n // 2, tl[1] + n // 2]),
                        self.dfs([tl[0], tl[1] + n // 2], [tl[0] + n //2, br[1]]),
                        self.dfs([tl[0]+n//2, tl[1]], [br[0], tl[1] + n//2]),
                        self.dfs([tl[0] + n // 2, tl[1] + n // 2], br))

    grid = []
    def construct(self, grid: List[List[int]]) -> 'Node':
        self.grid = grid
        n = len(grid)
        cur = self.dfs([0,0], [n,n])
        return cur

    # return self.construct(grid)