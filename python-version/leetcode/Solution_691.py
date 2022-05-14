from math import inf
from typing import List


class Solution:
    def minStickers(self, stickers: List[str], target: str) -> int:
        n = len(target)
        dp = [inf] * n
        memory = {}

        
