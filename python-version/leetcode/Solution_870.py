from typing import List


class Solution:
    def advantageCount(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n = len(nums1)
        idx1, idx2 = list(range(n)), list(range(n))
        idx1.sort(key=lambda i: nums1[i])
        idx2.sort(key=lambda i: nums2[i])

        res = [0 for _ in range(n)]
        left, right = 0, n-1
        for i in range(n):
            if nums1[idx1[i]] > nums2[idx2[left]]:
                res[idx2[left]]=nums1[idx1[i]]
                left+=1
            else:
                res[idx2[right]] = nums1[idx1[i]]
                right -= 1

        return res


print(Solution().advantageCount([2, 7, 11, 15], [1, 10, 4, 11]))
