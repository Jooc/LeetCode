from typing import List


class Solution:
    def makesquare_0(self, matchsticks: List[int]) -> bool:
        total_len = sum(matchsticks)
        if total_len % 4:
            return False
        matchsticks.sort(reverse=True)

        edges = [0] * 4
        def dfs(index):
            if index == len(matchsticks):
                return True
            for i in range(4):
                edges[i] += matchsticks[index]
                if edges[i] <= total_len // 4 and dfs(index+1):
                    return True
                edges[i] -= matchsticks[index]
            return False

        return dfs(0)


