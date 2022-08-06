from typing import List


class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        n, ans = len(words), []

        for i in range(n):
            for j in range(n):
                if i!= j and words[i] in words[j]:
                    ans.append(words[i])
                    break

        return ans
