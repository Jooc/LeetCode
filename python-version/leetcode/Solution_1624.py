class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:
        first_alpha_index = {}
        ans = -1

        for index,c in enumerate(s):
            if c in first_alpha_index:
                ans = max(index - first_alpha_index[c] - 1, ans)
            else:
                first_alpha_index[c] = index

        return ans
