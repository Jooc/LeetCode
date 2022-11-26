from typing import List


class Solution:
    def numSpecial(self, mat: List[List[int]]) -> int:
        sum_r = [sum(row) for row in mat]
        sum_c = [sum(col) for col in zip(*mat)]

        res = 0
        for i, row in enumerate(mat):
            for j, val in enumerate(row):
                if val == 1 and sum_r[i] == 1 and sum_c[j] == 1:
                    res += 1

        return res