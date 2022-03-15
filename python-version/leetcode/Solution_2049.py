from typing import List


class Solution:

    def countHighestScoreNodes(self, parents: List[int]) -> int:
        n = len(parents)
        children = [[] for _ in range(n)]
        for node, parent in enumerate(parents):
            if parent != -1:
                children[parent].append(node)

        print(children)

        max_score, counter = 0, 0
        def dfs(node: int) -> int:
            score = 1
            size = n - 1
            for child in children[node]:
                sz = dfs(child)
                score *= sz
                size -= sz
            if node != 0:
                score *= size
            nonlocal max_score, counter
            if score == max_score:
                counter += 1
            elif score > max_score:
                max_score, counter = score, 1
            #return the size of the tree with this node as root
            return n - size

        dfs(0)
        return counter
