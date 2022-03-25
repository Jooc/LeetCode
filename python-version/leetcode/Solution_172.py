class Solution:

    def main(self):
        a, b, c = 1, True, False

        if a:
            print(b)
        else:
            print(c)

    def trailingZeroes_0(self, n: int) -> int:
        return n // 5 + self.trailingZeroes(n // 5) if n else 0

    def trailingZeroes(self, n: int) -> int:
        ans = 0
        for i in range(5, n+1, 5):
            while i%5==0:
                i //= 5
                ans += 1
        return ans
