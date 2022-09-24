from typing import List


class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:
        if k == 0:
            return [0] * len(code)
        res = [-1] * len(code)
        n = len(code)
        code += code

        if k > 0:
            l, r = 1, k
        else:
            l, r = n + k, n - 1
        w = sum(code[l:r+1])
        for i in range(n):
            res[i] = w
            w -= code[l]
            w += code[r+1]
            l += 1
            r += 1

        return res
