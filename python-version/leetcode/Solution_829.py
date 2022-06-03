class Solution:
    def main(self):
        print(self.consecutiveNumbersSum(5))

    def consecutiveNumbersSum(self, n: int) -> int:
        if n <= 2:
            return 0
        if n % 2 == 0:
            return 1

        return self.consecutiveNumbersSum(n//2) + self.consecutiveNumbersSum(n//2 + 1) - 1


solution = Solution()
solution.main()