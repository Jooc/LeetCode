from typing import List


class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        rows, cols = len(grid), len(grid[0])
        ans = [[0] * cols for _ in range(rows)]

        for i, row in enumerate(grid):
            for j, val in enumerate(row):
                index = (i * cols + j + k) % (rows * cols)
                ans[index // cols][index % cols] = val

        return ans
