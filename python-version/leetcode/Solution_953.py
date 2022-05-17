from itertools import pairwise
from typing import List


class Solution:
    def main(self):
        print(self.isAlienSorted(["kuvp","q"], "ngxlkthsjuoqcpavbfdermiywz"))

    def isAlienSorted_0(self, words: List[str], order: str) -> bool:
        seq = {c: order for order, c in enumerate(order)}

        def is_ordered(a, b):
            oped = False
            for i in range(min(len(a), len(b))):
                if a[i] != b[i]:
                    if seq[a[i]] > seq[b[i]]:
                        return False
                    else:
                        oped = True
                        break
            if not oped and len(a) > len(b):
                return False

            return True

        for i in range(1, len(words)):
            if not is_ordered(words[i - 1], words[i]):
                return False

        return True


    def isAlienSorted(self, words: List[str], order: str) -> bool:
        index = {c: i for i, c in enumerate(order)}
        return all(s <= t for s, t in pairwise([index[c] for c in word] for word in words))

