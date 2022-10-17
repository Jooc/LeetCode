from collections import Counter
from typing import List


class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        counter = Counter()

        left, ans = 0, 0
        for right in range(left, len(fruits)):
            counter[fruits[right]] += 1
            while len(counter.keys()) > 2:
                counter[fruits[left]] -= 1
                if counter[fruits[left]] == 0:
                    counter.pop(fruits[left])
                left += 1
            ans = max(ans, right - left + 1)

        return ans


print(Solution().totalFruit([0, 1, 2, 2]))
