from typing import List


class Solution:
    def main(self):
        print(self.goodDaysToRobBank([1,1,1,1,1], 0))

    def goodDaysToRobBank(self, security: List[int], time: int) -> List[int]:
        n = len(security)
        left2right, right2left = [0] * n, [0] * n
        for i in range(1, n):
            left2right[i] = left2right[i-1] + 1 if security[i] <= security[i-1] else 0
        for i in range(n-2, -1, -1):
            right2left[i] = right2left[i+1] + 1 if security[i] <= security[i+1] else 0

        return [i for i in range(n) if left2right[i] >= time and right2left[i] >= time]