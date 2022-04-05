class Solution:
    def countPrimeSetBits(self, left: int, right: int) -> int:
        def hamming_weight(num):
            res = 0
            while num:
                num &= num-1
                res += 1
            return res

        def is_prime(num):
            if num < 2:
                return False
            i = 2
            while i * i <= num:
                if num % i == 0:
                    return False
                i += 1
            return True

        return len([i for i in range(left, right+1) if is_prime(hamming_weight(i))])
