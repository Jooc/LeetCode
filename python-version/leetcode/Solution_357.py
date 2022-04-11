class Solution:
    def main(self):
        print(self.countNumbersWithUniqueDigits(3))
    def countNumbersWithUniqueDigits_0(self, n: int) -> int:
        if n == 0: return 1
        if n == 1: return 10
        ans, cur, factor = 10, 9, 9
        for _ in range(1, n):
            cur *= factor
            ans += cur
            factor -= 1

        return ans

    def countNumbersWithUniqueDigits(self, n: int) -> int:
        if n == 0: return 1
        if n == 1: return 10
        ans, cur = 10, 9
        for i in range(n-1):
            cur *= 9 - i
            ans += cur
        return ans

