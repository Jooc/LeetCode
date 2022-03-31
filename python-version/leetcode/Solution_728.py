from typing import List


class Solution:
    def main(self):
        print(self.selfDividingNumbers(1, 22))

    def selfDividingNumbers_0(self, left: int, right: int) -> List[int]:
        def is_self_dividing(num) -> bool:
            temp = num
            while temp != 0:
                letter = temp % 10
                if letter == 0 or num % letter != 0:
                    return False
                temp //= 10
            return True

        ans = []
        for num in range(left, right+1):
            if is_self_dividing(num):
                ans.append(num)

        return ans

    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
        def is_self_dividing(num) -> bool:
            temp = num
            while temp:
                temp, letter = divmod(temp, 10)
                if letter == 0 or num % letter:
                    return False
            return True

        return [i for i in range(left, right + 1) if is_self_dividing(i)]
