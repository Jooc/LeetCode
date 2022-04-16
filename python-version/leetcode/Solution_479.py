class Solution:
    def largestPalindrome(self, n: int) -> int:
        if n == 1: return 9

        upper_bound = 10 ** n - 1
        for left in range(upper_bound, upper_bound // 10, -1):
            p, x = left, left
            while x:
                p = p * 10 + x % 10
                x //= 10

            x = upper_bound
            # 判断到 x = 根号p 即可
            # 因为继续枚举，x < p/x；若x是p的因子，p/x必然也是
            while x*x >= p:
                if p % x == 0:
                    return p % 1337
                x -= 1
