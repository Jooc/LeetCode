from typing import List
from itertools import pairwise

class Solution:
    def main(self):
        print(self.alienOrder(["wrt", "wrf", "er", "ett", "rftt"]))

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

        VISITING, VISITED = 1, 2
        states = {}
        order = []

        def dfs(u: str) -> bool:
            states[u] = VISITING
            for v in graph[u]:
                if v not in states:
                    if not dfs(v):
                        return False
                elif  states[v] == VISITING:
                    return False
            order.append(u)
            states[u] = VISITED
            return True

        return ''.join(reversed(order)) if all(dfs(u) for u in graph if u not in states) else ""



solution = Solution()
print(solution.main())
