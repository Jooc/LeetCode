from collections import deque
from typing import List

class Solution:
    def main(self):
        print(self.minMutation("AACCTTGG", "AATTCCGG", ["AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"]))
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        if start == end:
            return 0

        def diff_one(a:str, b:str):
            return sum([x != y for x, y in zip(a,b)]) == 1

        bank += [start]
        n = len(bank)
        start_index = n - 1
        adj = [[] for _ in range(n)]
        end_index = -1
        for i in range(n):
            if bank[i] == end:
                end_index = i
            for j in range(i, n):
                if diff_one(bank[i], bank[j]):
                    adj[i].append(j)
                    adj[j].append(i)
        print(start_index, end_index)
        print(adj)

        q = deque([(start_index, 0)])
        while len(q) != 0:
            cur_index, step = q.popleft()
            for available in adj[cur_index]:
                if available == end_index:
                    return step + 1
                if step > n:
                    return -1
                q.append((available, step+1))

        return -1
