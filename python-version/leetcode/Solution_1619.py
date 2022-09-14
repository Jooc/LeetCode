from typing import List


class Solution:
    def trimMean(self, arr: List[int]) -> float:
        arr.sort()
        n = len(arr)
        return sum(arr[n//20: -n//20])/n*0.9