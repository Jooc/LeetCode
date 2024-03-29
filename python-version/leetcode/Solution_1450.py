from typing import List

class Solution:
    def busyStudent(self, startTime: List[int], endTime: List[int], queryTime: int) -> int:
        return sum([1 for i in range(len(startTime)) if startTime[i] <= queryTime <= endTime[i]])