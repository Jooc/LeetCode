from typing import List


class Solution:
    def canFormArray(self, arr: List[int], pieces: List[List[int]]) -> bool:
        indices = [0] * len(pieces)

        for num in arr:
            for i in range(len(indices)):
                if indices[i] < len(pieces[i]) and pieces[i][indices[i]] == num:
                    indices[i] += 1
                    break
            else:
                return False

        return True
