from math import gcd


class Solution:
    def fractionAddition(self, expression: str) -> str:
        denominator, numerator = 0, 1
        i, n = 0, len(expression)
        while i < n:
            denominator_temp, sign = 0, 1
            if expression[i] == '-' or expression[i] == '+':
                if expression[i] == '-':
                    sign = -1
                i += 1

            while i < n and expression[i].isdigit():
                denominator_temp = denominator_temp * 10 + int(expression[i])
                i += 1
            denominator_temp = sign * denominator_temp
            i += 1

            numerator_temp = 0
            while i < n and expression[i].isdigit():
                numerator_temp = numerator_temp * 10 + int(expression[i])
                i += 1

            denominator = denominator * numerator_temp + numerator * denominator_temp
            numerator *= numerator_temp

        if denominator == 0:
            return '0/1'
        g = gcd(abs(denominator), numerator)
        return "{}/{}".format(denominator//g, numerator//g)

soultion = Solution()
print(soultion.fractionAddition("-1/2+1/2"))