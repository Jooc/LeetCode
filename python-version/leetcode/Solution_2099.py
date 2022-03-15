from typing import List

import collections

class Solution:
    def main(self):
        print(self.platesBetweenCandles("***|**|*****|**||**|*", [[1,17],[4,5],[14,17],[5,11],[15,16]]))
        # print(self.platesBetweenCandles("**|**|***|", [[2,5],[5,9]]))

    #Simple loop
    def platesBetweenCandles_0(self, s: str, queries: List[List[int]]) -> List[int]:
        ans = []
        for query in queries:
            workspace = collections.deque()
            counter = 0
            for index in range(query[0], query[1]+1):
                if len(workspace) == 0:
                    if s[index] == '|':
                        workspace.append('|')
                else:
                    if s[index] == '*':
                        workspace.append('*')
                    else:
                        counter += len(workspace) - 1
                        workspace.clear()
                        workspace.append('|')
            ans.append(counter)

        return ans


    def platesBetweenCandles_1(self, s: str, queries: List[List[int]]) -> List[int]:
        n = len(s)
        pre_sum, temp = [0] * n, 0
        start_index = 0
        for index, ch in enumerate(s):
            if ch == '|':
                start_index = index
                break
        for index in range(start_index, n):
            if s[index] == '*':
                temp += 1
            else:
                pre_sum[index] = temp

        left, right = [0] * n, [0] * n
        l, r = -1, -1
        for index in range(n):
            if s[index] == '|':
                l = index
            left[index] = l
        for index in range(n-1, -1, -1):
            if s[index] == '|':
                r = index
            right[index] = r

        ans = [0] * len(queries)
        for index, (x, y) in enumerate(queries):
            if x == y:
                ans[index] = 0
            else:
                ans[index] = max(0, pre_sum[left[y]] - pre_sum[right[x]])

        print(pre_sum)
        print(left)
        print(right)

        return ans

    def platesBetweenCandles(self, s: str, queries: List[List[int]]) -> List[int]:
        n = len(s)
        pre_sum, temp = [0] * n, 0
        start_index = 0
        for index, ch in enumerate(s):
            if ch == '|':
                start_index = index
                break
        left, l = [-1] * n, -1
        for index in range(start_index, n):
            if s[index] == '*':
                temp += 1
            else:
                pre_sum[index] = temp
                l = index
            left[index] = l

        right, r = [0] * n, -1
        for index in range(n-1, -1, -1):
            if s[index] == '|':
                r = index
            right[index] = r

        ans = [0] * len(queries)
        for index, (x, y) in enumerate(queries):
            if x == y:
                ans[index] = 0
            else:
                ans[index] = max(0, pre_sum[left[y]] - pre_sum[right[x]])

        return ans




