from typing import List


class Solution:
    def distanceBetweenBusStops(self, distance: List[int], start: int, destination: int) -> int:
        cur = start
        d = 0
        while cur != destination:
            d += distance[cur]
            cur = (cur + 1) % len(distance)
        return min(d, sum(distance)-d)



