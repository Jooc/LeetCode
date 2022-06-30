from math import sqrt


class Solution:
    def numPrimeArrangements(self, n: int) -> int:
        numPrimes = sum(self.isPrime(i) for i in range(1, n+1))
        return self.factorical(numPrimes) * self.factorical(n-numPrimes) % (10 ** 9 + 7)

    def isPrime(self, n):
        if n == 1:
            return 0
        for i in range(2, int(sqrt(n)) + 1):
            if n % i == 0:
                return 0
        return 1

    def factorical(self, n):
        res = 1
        for i in range(1, n + 1):
            res *= i
            res %= (10 ** 9 + 7)
        return res