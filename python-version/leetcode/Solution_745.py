from typing import List

class WordFilter:

    def __init__(self, words: List[str]):
        self.d = {}
        for i, word in enumerate(words):
            m = len(word)
            for prefix_len in range(1, m+1):
                for suffix_len in range(1, m+1):
                    self.d[word[:prefix_len] + '#' + word[-suffix_len:]] = i

    def f(self, pref: str, suff: str) -> int:
        return self.d.get(pref + '#' + suff, -1)



# Your WordFilter object will be instantiated and called as such:
# obj = WordFilter(words)
# param_1 = obj.f(pref,suff)