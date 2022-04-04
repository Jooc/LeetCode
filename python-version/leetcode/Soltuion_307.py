from typing import List


class NumArray_0:
    def __init__(self, nums: List[int]):
        self.nums = nums
        self.prefix = [0] * (len(nums) + 1)
        for index in range(1, len(nums) + 1):
            self.prefix[index] = self.prefix[index - 1] + nums[index - 1]

    def update(self, index: int, val: int) -> None:
        diff = val - self.nums[index]
        self.nums[index] = val
        for i in range(index + 1, len(self.prefix)):
            self.prefix[i] += diff

    def sumRange(self, left: int, right: int) -> int:
        print(self.prefix[right + 1] - self.prefix[left])
        return self.prefix[right + 1] - self.prefix[left]


class NumArray:
    def __init__(self, nums: List[int]):
        self.nums = nums
        self.tree = [0] * (len(nums) + 1)
        for i, num in enumerate(nums, 1):
            self.add(i, num)

    def add(self, index: int, val: int):
        while index < len(self.tree):
            self.tree[index] += val
            index += index & -index

    def prefixSum(self, index) -> int:
        s = 0
        while index:
            s += self.tree[index]
            index &= index - 1
        return s

    def update(self, index: int, val: int) -> None:
        self.add(index + 1, val - self.nums[index])
        self.nums[index] = val

    def sumRange(self, left: int, right: int) -> int:
        return self.prefixSum(right + 1) - self.prefixSum(left)


num_array = NumArray([7, 2, 7, 2, 0])
num_array.update(4, 6)
num_array.update(0, 2)
num_array.update(0, 9)
num_array.sumRange(4, 4)
num_array.update(3, 8)
num_array.sumRange(0, 4)
num_array.update(4, 1)
num_array.sumRange(0, 3)
num_array.sumRange(0, 4)
num_array.update(0, 4)
