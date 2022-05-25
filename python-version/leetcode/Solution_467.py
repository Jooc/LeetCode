class Solution:
    def findSubstringInWraproundString(self, p: str) -> int:
        dp = defaultdict(int)
        k = 0
        for i, ch in enumerate(p):
            if i > 0 and (ord(ch) - ord(p[i - 1])) % 26 == 1:  # 字符之差为 1 或 -25
                k += 1
            else:
                k = 1
            dp[ch] = max(dp[ch], k)
        return sum(dp.values())
