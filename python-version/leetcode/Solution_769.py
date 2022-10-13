from typing import List


class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        chunk_count = 0
        mx = 0
        for i, x in enumerate(arr):
            mx = max(mx, x)
            if mx == i:
                chunk_count += 1
        return chunk_count