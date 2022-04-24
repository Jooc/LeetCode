class Solution:
    def main(self):
        print(self.binaryGap(6))

    def binaryGap_0(self, n: int) -> int:
        if n == 0:
            return n

        max_distance = 0
        have_neigh = False
        while n % 2 == 0:
            n //= 2
        while n != 0:
            distance = 0
            if n % 4 == 3:
                have_neigh = True
            while n % 2 == 0:
                distance += 1
                n //= 2
            while n % 2 != 0:
                n //= 2

            max_distance = max(max_distance, distance + 1 if distance > 0 else distance)

        return max_distance if max_distance > 1 else 1 if have_neigh else 0

    def binaryGap(self, n: int) -> int:
        last, ans, i = -1, 0, 0
        while n:
            if n & 1:
                if last != -1:
                    ans = max(ans, i - last)
                last = i
            n >>= 1
            i += 1
        return ans