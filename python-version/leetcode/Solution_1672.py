from typing import List


class Solution:
    def maximumWealth(self, accounts: List[List[int]]) -> int:
        ans = 0
        for account in accounts:
            sum = 0
            for money in account:
                sum += money
            ans = max(ans, sum)
        return ans