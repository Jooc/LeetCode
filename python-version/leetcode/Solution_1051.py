from typing import List


class Solution:
    def main(self):
        print(self.heightChecker([1,1,4,2,1,3]))
    def heightChecker(self, heights: List[int]) -> int:
        print(heights, sorted(heights))
        return sum([int(x != y) for x, y in zip(heights, sorted(heights))])