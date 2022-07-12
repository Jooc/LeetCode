from typing import List


class Solution:
    def oddCells(self, m: int, n: int, indices: List[List[int]]) -> int:
        record = [[0 for _ in range(n)] for _ in range(m)]
        for ri, ci in indices:
            for j in range(n):
                record[ri][j] = (record[ri][j] + 1) % 2
            for i in range(m):
                record[i][ci] = (record[i][ci] + 1) % 2

        return sum([sum(row) for row in record])
