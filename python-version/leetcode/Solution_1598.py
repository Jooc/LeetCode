from typing import List


class Solution:
    def minOperations(self, logs: List[str]) -> int:
        count = 0
        for log in logs:
            if log[:2] == '..':
                count = max(0, count - 1)
            elif log[0] != '.':
                count += 1
        return count

solution = Solution()
print(solution.minOperations(["d1/","d2/","../","d21/","./"]))