from typing import List


class Solution:
    def minRefuelStops(self, target: int, startFuel: int, stations: List[List[int]]) -> int:
        n = len(stations)
        dp = [startFuel] + [0] * n

        for i, (pos, fuel) in enumerate(stations):
            for j in range(i - 1, -1, -1):
                if dp[j] >= pos:
                    dp[j+1] = max(dp[j + 1], dp[j] + fuel)

        return next((i for i, j in enumerate(dp) if j >= target), -1)