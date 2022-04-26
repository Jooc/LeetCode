from typing import List


class Solution:
    def main(self):
        print(self.projectionArea([[1,2],[3,4]]))

    def projectionArea(self, grid: List[List[int]]) -> int:
        xy = sum(y > 0 for row in grid for y in row)
        yz = sum(map(max, grid))
        xz = sum(map(max, zip(*grid)))

        return xy + yz + xz