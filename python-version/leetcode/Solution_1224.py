from collections import Counter
from typing import List



class Solution:
    def maxEqualFreq(self, nums: List[int]) -> int:
        count, freq = Counter(), Counter()
        ans = maxFreq = 0

        for i, num in enumerate(nums):
            if count[num]:
                freq[count[num]] -= 1
            count[num] += 1
            freq[count[num]] += 1
            maxFreq = max(maxFreq, count[num])

            if maxFreq == 1 or \
                freq[maxFreq] * maxFreq + freq[maxFreq-1]*(maxFreq-1) == i+1 and freq[maxFreq] == 1 or \
                freq[maxFreq] * maxFreq + 1 == i + 1 and freq[i] == 1:
                ans = max(ans, i + 1)

        return ans

