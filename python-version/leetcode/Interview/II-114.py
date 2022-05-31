from typing import List
from itertools import pairwise


class Solution:
    def main(self):
        print(self.alienOrder(["wrt","wrf","er","ett","rftt"]))

    def alienOrder(self, words: List[str]) -> str:
        graph = {}
        for c in words[0]:
            graph[c] = []
        for s, t in pairwise(words):
            for c in t:
                graph.setdefault(c, [])
            for u, v in zip(s, t):
                if u != v:
                    graph[u].append(v)
                    break
            else:
                if len(s) > len(t):
                    return ""

        print(graph)

        VISITING, VISITED = 1, 2
        states = {}
        order = []


solution = Solution()
print(solution.main())