from itertools import combinations
from typing import List


class Solution:
    def main(self):
        print(self.largestTriangleArea([[0,0],[0,1],[1,0],[0,2],[2,0]]))

    def largestTriangleArea_0(self, points: List[List[int]]) -> float:
        def triangle_area(a, b, c, d, e, f) -> float:
            return abs(a * d + b * e + c * f - e * d - b * c - a * f) / 2

        return max([triangle_area(x1, y1, x2, y2, x3, y3) for (x1, y1), (x2, y2), (x3, y3) in combinations(points, 3)])

    def getConvesHull(self, points):
        def cross(p, q, r) -> int:
            return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0])

        n = len(points)
        if n < 4:
            return points

        points.sort()
        hull = []

        for i, p in enumerate(points):
            while len(hull) > 1 and cross(hull[-2], hull[-1], p) <= 0:
                hull.pop()
            hull.append(p)
        m = len(hull)
        for i in range(n - 2, -1, -1):
            while len(hull) > m and cross(hull[-2], hull[-1], points[i]) <= 0:
                hull.pop()
            hull.append(points[i])
        hull.pop()
        return hull

    def largestTriangleArea(self, points: List[List[int]]) -> float:
        def triangle_area(a, b, c, d, e, f) -> float:
            return abs(a * d + b * e + c * f - e * d - b * c - a * f) / 2

        convex_hull = self.getConvesHull(points)
        print(convex_hull)
        ans, n = 0, len(convex_hull)
        for i, p in enumerate(convex_hull):
            k = i + 2
            for j in range(i + 1, n - 1):
                q = convex_hull[j]
                while k + 1 < n:
                    cur_area = triangle_area(p[0], p[1], q[0], q[1], convex_hull[k][0], convex_hull[k][1])
                    print(cur_area)
                    next_area = triangle_area(p[0], p[1], q[0], q[1], convex_hull[k + 1][0], convex_hull[k + 1][1])
                    if cur_area > next_area:
                        break
                    k += 1
                ans = max(ans, triangle_area(p[0], p[1], q[0], q[1], convex_hull[k][0], convex_hull[k][1]))
        return ans
