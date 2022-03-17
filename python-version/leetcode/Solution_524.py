from typing import List


class Solution:
    def main(self):
        print(self.findLongestWord("abpcplea", ["ale", "apple", "monkey", "plea"]))

    def isSub(self, s, dic)->bool:
        n = len(s)
        m = len(dic)
        if m > n:
            return False

        index = 0
        for c in dic:
            while index < n and s[index] != c:
                index += 1
            if index >= n:
                return False
            index += 1

        return True

    def findLongestWord(self, s: str, dictionary: List[str]) -> str:
        dictionary.sort(key=lambda x: (-len(x), x))

        print(dictionary)

        for d in dictionary:
            if self.isSub(s, d):
                return d

        return ''
