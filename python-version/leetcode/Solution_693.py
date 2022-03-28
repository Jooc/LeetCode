class Solution:
    def main(self):
        print(self.hasAlternatingBits(10))

    def hasAlternatingBits_0(self, n: int) -> bool:
        print(bin(n))

        n_bits = 0
        while n >> n_bits != 0:
            n_bits += 1

        print(bin(n & 0b11111111111111111111111111111111))
        print(bin((0b01010101010101010101010101010101 ^ n) & (0b11111111111111111111111111111111 >> (32 - n_bits))))
        return (0b01010101010101010101010101010101 ^ n) & (0b11111111111111111111111111111111 >> (32 - n_bits)) == 0 or (0b10101010101010101010101010101010 ^ n) & (0b11111111111111111111111111111111 >> (32 - n_bits)) == 0

    def hasAlternatingBits(self, n: int) -> bool:
        a = n ^ (n>>1)
        return a & (a+1) == 0
