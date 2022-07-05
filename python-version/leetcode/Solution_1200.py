from typing import List


class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        arr.sort()
        min_diff = inf
        ans = []
        for i in range(1, len(arr)):
            if arr[i] - arr[i-1] < min_diff:
                min_diff = arr[i]-arr[i-1]
                ans = []
            if arr[i] - arr[i-1] == min_diff:
                ans.append([arr[i-1], arr[i]])

        return ans
