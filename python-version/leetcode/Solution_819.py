from collections import Counter
from typing import List


class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        ban = set(banned)
        freq = Counter()

        word, n = "", len(paragraph)
        for c in paragraph:
            if c.isalpha():
                word += c.lower()
            elif word:
                if word not in ban:
                    freq[word] += 1
                word = ""
        if word: freq[word] += 1
        max_freq = max(freq.values())
        return next(word for word, f in freq.items() if f == max_freq)