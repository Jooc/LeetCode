from typing import List

class Solution:
    def missingRolls_0(self, rolls: List[int], mean: int, n: int) -> List[int]:
        m = len(rolls)
        sum_m = 0
        for roll in rolls:
            sum_m += roll

        sum_n = (n + m) * mean - sum_m
        if sum_n > 6 * n or sum_n < n:
            return []

        ans, index = [1] * n, 0
        sum_n -= n
        while sum_n > 0:
            ans[index] += 1
            if ans[index] == 6:
                index += 1
            sum_n -= 1

        return ans

    def missingRolls(self, rolls: List[int], mean: int, n: int) -> List[int]:
        missing_sum = mean * (n+len(rolls)) - sum(rolls)
        if not n <= missing_sum <= 6 * n:
            return []
        quotient, remainder = divmod(missing_sum, n)
        return [quotient + 1] * remainder + [quotient] * (n-remainder)