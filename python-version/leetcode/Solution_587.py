from typing import List


class Solution:
    def outerTrees(self, trees: List[List[int]]) -> List[List[int]]:
        # 叉积大于0，在左边； 小于0在右边；等于0平行
        def cross(p, q, r) -> int:
            return (p[0] - q[0]) * (q[1] - r[1]) - (p[1] - q[1]) * (q[0] - r[0])

        n = len(trees)
        if n < 4:
            return trees

        leftMost = 0
        for i, tree in enumerate(trees):
            if tree[0] < trees[leftMost][0]:
                leftMost = i

        ans = []
        vis = [False] * n
        p = leftMost

        while True:
            q = (p+1)%n
            for r, tree in enumerate(trees):
                if cross(trees[p], trees[q], trees[r]) < 0:
                    q = r
            for i, b in enumerate(vis):
                if not b and i != p and cross(trees[p], trees[q], trees[i]) == 0:
                    ans.append(trees[i])
                    vis[i] = True
            if not vis[q]:
                ans.append(trees[q])
                vis[q] = True
            p = q
            if p == leftMost:
                break
        return ans
