from typing import List
from collections import deque

class Solution:
    def diStringMatch(self, s: str) -> List[int]:
        candidates = deque(list(range(len(s) + 1)))
        ans = []
        for c in s:
            if c == 'I':
                ans.append(candidates.popleft())
            else:
                ans.append(candidates.pop())
        ans.append(candidates[0])
        return ans
