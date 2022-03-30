from typing import List
from sortedcontainers import SortedList

class Solution:
    def main(self):
        print(self.busiestServers(3, [1,2,3,4], [1,2,1,2]))


    def busiestServers_0(self, k: int, arrival: List[int], load: List[int]) -> List[int]:
        free_at, counter = [0]*k, [0]*k

        for index in range(len(arrival)):
            for server in range(k):
                if free_at[server] <= arrival[index]:
                    free_at[server] += (load[index] + arrival[index])
                    counter[server] += 1
                    break

        print(counter)

        ans = []
        max_counter = 0
        for index, c in enumerate(counter):
            if c == max_counter:
                ans.append(index)
            elif c > max_counter:
                max_counter = c
                ans = [index]

        return ans

    def busiestServers_0(self, k: int, arrival: List[int], load: List[int]) -> List[int]:
        available = SortedList(range(k))
        busy = []
        request = [0] * k
        for i, (start, t) in enumerate(zip(arrival, load)):
            while busy and busy[0][0] <= start:
                available.add(busy[0][1])