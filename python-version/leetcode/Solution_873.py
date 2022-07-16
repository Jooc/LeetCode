from typing import List


class Solution:
    def lenLongestFibSubseq(self, arr: List[int]) -> int:
        indices = {x: i for i, x in enumerate(arr)}

        ans, n = 0, len(arr)
        dp = [[0] * n for _ in range(n)]

        for i, x in enumerate(arr):
            for j in range(n - 1, -1, -1):
                if arr[j] * 2 <= x:
                    break
                if x - arr[j] in indices:
                    k = indices[x - arr[j]]
                    dp[j][i] = max(dp[k][j] + 1, 3)
                    ans = max(ans, dp[j][i])
        return ans
