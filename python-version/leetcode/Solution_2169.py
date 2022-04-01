class Solution:
    def countOperations_0(self, num1: int, num2: int) -> int:
        ans = 0
        while num1 and num2:
            if num1 < num2:
                num2 -= num1
            else:
                num1 -= num2
            ans += 1
        return ans

    def countOperations(self, num1: int, num2: int) -> int:
        ans = 0
        while num1 and num2:
            ans += num1 // num2
            num1 %= num2
            num1, num2 = num2, num1
        return ans



