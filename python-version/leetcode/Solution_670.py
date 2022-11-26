class Solution:
    def maximumSwap_0(self, num: int) -> int:
        ans = num
        s = list(str(num))
        print(s)
        for i in range(len(s)):
            for j in range(i):
                s[i], s[j] = s[j], s[i]
                ans = max(ans, int(''.join(s)))
                s[i], s[j] = s[j], s[i]

        return ans

    def maximumSwap(self, num: int) -> int:
        pass


print(Solution().maximumSwap(2736))