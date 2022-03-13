from typing import List

import sys

class Solution:
    def main(self):
        print(self.validUtf8([197,130,1]))

    def validUtf8(self, data: List[int]) -> bool:
        mask1, mask2 = 128, 192

        def get_bytes(num: int) -> int:
            # 0开头, 字符长1字节
            if (num & mask1) == 0:
                return 1
            # else
            n, mask = 0, mask1
            while num & mask:
                n += 1
                # 长度大于4
                if n > 4:
                    return -1
                mask >>= 1
            return n if n >= 2 else -1

        index, m = 0, len(data)
        while index < m:
            n = get_bytes(data[index])
            if n < 0 or index + n > m or any((ch & mask2) != mask1 for ch in data[index+1:index+n]):
                return False
            index += n

        return True







