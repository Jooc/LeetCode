from typing import List


class Solution:
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        g = [[] for _ in range(n)]
        for x, y in dislikes:
            g[x - 1].append(y - 1)
            g[y - 1].append(x - 1)
        color = [0] * n

        def dfs(x: int, c: int):
            color[x] = c
            return all(color[y] != c and (color[y] or dfs(y, -c)) for y in g[x])

        return all(c or dfs(i, 1) for i, c in enumerate(color))
