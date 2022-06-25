from typing import List


class Solution:
    def main(self):
        print(self.minCost([[17,2,17],[16,16,5],[14,3,19]]))

    def minCost(self, costs: List[List[int]]) -> int:
        dp = costs[0]
        for i in range(1, len(costs)):
            last_dp = list(dp)
            dp[0] = min(last_dp[1], last_dp[2]) + costs[i][0]
            dp[1] = min(last_dp[0], last_dp[2]) + costs[i][1]
            dp[2] = min(last_dp[0], last_dp[1]) + costs[i][2]

        return min(dp[0],min(dp[1], dp[2]))


    def minCost_0(self, costs: List[List[int]]):
        dp = costs[0]
        for i in range(1, len(costs)):
            dp = [min(dp[j-1], dp[j-2]) + c for j, c in enumerate(costs[i])]
        return min(dp)

solution = Solution()
solution.main()