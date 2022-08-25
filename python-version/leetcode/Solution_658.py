from typing import List

class Solution:
    def findClosestElements_0(self, arr: List[int], k: int, x: int) -> List[int]:
        arr.sort(key=lambda num: abs(num-x))
        return sorted(arr[:k])

    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left, right =0, len(arr)-1
        while left < right:
            mid = (left + right) // 2
            if arr[mid] == x:
                right = mid
                break
            elif arr[mid] < x:
                left = mid + 1
            else:
                right = mid - 1
        right = max(right, 0)


        left = right - 1
        for _ in range(k):
            if left < 0:
                right += 1
            elif right >= len(arr) or x - arr[left] <= arr[right] - x:
                left -= 1
            else:
                right += 1
        return arr[left + 1: right]
