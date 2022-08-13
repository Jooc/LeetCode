from collections import Counter
from typing import List

class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        counter = Counter()
        res = 0
        for x, y in zip(arr, sorted(arr)):
            counter[x] += 1
            if counter[x] == 0:
                del counter[x]
            counter[y] -= 1
            if counter[y] == 0:
                del  counter[y]
            if len(counter) == 0:
                res += 1

        return res


