from typing import List

class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        ans, temp = [], {}

        for i, size in enumerate(groupSizes):
            if size not in temp.keys():
                temp[size] = []
            temp[size].append(i)
            if len(temp[size]) == size:
                ans.append(temp[size])
                del temp[size]

        return ans