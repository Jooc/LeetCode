from collections import Counter
from typing import List


class Solution:
    def canBeEqual_0(self, target: List[int], arr: List[int]) -> bool:
        counter = Counter()
        for num in target:
            counter[num] += 1
        for num in arr:
            counter[num] -= 1

        for c in counter:
            if c != 0:
                return False
        return True

    def canBeEqual(self, target: List[int], arr: List[int]) -> bool:
        return Counter(target) == Counter(arr)

