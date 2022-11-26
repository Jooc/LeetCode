from typing import List


class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        seq = {v: i for i, v in enumerate(sorted(set(arr)), 1)}
        return [seq[num] for num in arr]
