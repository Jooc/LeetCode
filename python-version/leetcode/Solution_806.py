from typing import List


class Solution:
    def numberOfLines(self, widths: List[int], s: str) -> List[int]:
        level, sum = 1, 0
        for c in s:
            sum += widths[ord(c) - ord('a')]
            if sum > 100:
                level += 1
                sum = widths[ord(c)-ord('a')]

        return [level, sum]

