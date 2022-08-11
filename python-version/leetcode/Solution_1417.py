class Solution:
    def reformat_0(self, s: str) -> str:
        s0, s1 = [], []
        for c in s:
            if c.isdigit():
                s0.append(c)
            else:
                s1.append(c)

        if abs(len(s0) - len(s1)) > 1:
            return ''

        ans = ''
        if len(s0) > len(s1):
            ans += str(s0.pop(0))
            s0, s1 = s1, s0
        elif len(s0) < len(s1):
            ans += s1.pop(0)

        for i in range(len(s0)):
            ans += str(s0[i])
            ans += str(s1[i])

        return ans

    def reformat(self, s: str) -> str:
        sum_digit = sum(c.isdigit() for c in s)
        sum_alpha = len(s) - sum_digit
        if abs(sum_digit - sum_alpha) > 1:
            return ""

        flag = sum_digit > sum_alpha
        t = list(s)
        j = 1
        for i in range(0, len(t), 2):
            if t[i].isdigit() != flag:
                while t[j].isdigit() != flag:
                    j += 2
                t[i], t[j] = t[j], t[i]

        return ''.join(t)


solution = Solution()
print(solution.reformat('abcde12345'))