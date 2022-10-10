from typing import List


class Solution:
    def minSwap(self, nums1: List[int], nums2: List[int]) -> int:
        n = len(nums1)
        dp_0, dp_1 = [0 for _ in range(n)], [0 for _ in range(n)]
        dp_1[0] = 1

        for i in range(1, n):
            flag1 = nums1[i] > nums1[i - 1] and nums2[i] > nums2[i - 1]
            flag2 = nums1[i] > nums2[i - 1] and nums2[i] > nums1[i - 1]
            if flag1 and not flag2:
                dp_0[i] = dp_0[i - 1]
                dp_1[i] = dp_1[i - 1] + 1
            elif not flag1 and flag2:
                dp_0[i] = dp_1[i - 1]
                dp_1[i] = dp_0[i - 1] + 1
            else:
                dp_0[i] = min(dp_0[i - 1], dp_1[i - 1])
                dp_1[i] = min(dp_0[i - 1], dp_1[i - 1]) + 1

        return min(dp_0[n - 1], dp_1[n - 1])


print(Solution().minSwap([0, 4, 4, 5, 9], [0, 1, 6, 8, 10]))
