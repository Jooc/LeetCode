from typing import List

class Solution:
    def main(self):
        print(self.calPoints(["5","2","C","D","+"]))
    def calPoints(self, ops: List[str]) -> int:
        ans = 0
        points = []
        for op in ops:
            if op == '+':
                point = points[-1] + points[-2]
            elif op == 'D':
                point = 2 * points[-1]
            elif op == 'C':
                ans -= points.pop()
                continue
            else:
                point = int(op)
            ans += point
            points.append(point)
        print(points)
        return ans
