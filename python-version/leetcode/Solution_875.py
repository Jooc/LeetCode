from bisect import bisect_left
from typing import List


class Solution:
    def main(self):
        print(self.minEatingSpeed([3,6,7,22], 8))

    def minEatingSpeed_0(self, piles: List[int], h: int) -> int:
        low, high = 1, max(piles)
        k = high
        while low < high:
            speed = (high - low) // 2 + low
            cost = sum([(pile + speed - 1)//speed for pile in piles])
            if cost <= h:
                k = speed
                high = speed
            else:
                low = speed + 1
        return k

    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        return bisect_left(range(max(piles)), -h, 1, key=lambda k: -sum((pile + k - 1) // k for pile in piles))
