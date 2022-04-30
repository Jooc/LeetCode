class Solution:
    def main(self):
        print(self.convertToBase7(100))

    def convertToBase7(self, num: int) -> str:
        ans = []

        is_minus = False
        if num < 0:
            is_minus = True
            num = -num

        while num:
            ans.append(str(num % 7))
            num //= 7

        if is_minus:
            ans.append('-')

        return ''.join(reversed(ans))
