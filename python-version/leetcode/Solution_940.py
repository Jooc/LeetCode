class Solution:
    def distinctSubseqII_0(self, s: str) -> int:
        mod = 10 ** 9 + 7
        last = [-1] * 26
        n = len(s)
        f = [1] * n

        for i, ch in enumerate(s):
            for j in range(26):
                if last[j] != -1:
                    f[i] = (f[i] + f[last[j]]) % mod
            last[ord(s[i]) - ord('a')] = i

        ans = 0
        for i in range(26):
            if last[i] != -1:
                ans = (ans + f[last[i]]) % mod
        return ans

    def distinctSubseqII(self, s: str) -> int:
        mod = 10 ** 9 + 7

        g = [0] * 26
        total = 0
        for i, ch in enumerate(s):
            oi = ord(s[i]) - ord("a")
            g[oi], total = (1 + total) % mod, (total * 2 + 1 - g[oi]) % mod

        return total
