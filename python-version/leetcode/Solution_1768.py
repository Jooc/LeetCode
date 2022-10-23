class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        n1, n2 = len(word1), len(word2)
        idx1 = idx2 = 0

        ans = []
        while idx1 < n1 or idx2 < n2:
            if idx1 < n1:
                ans.append(word1[idx1])
                idx1 += 1
            if idx2 < n2:
                ans.append(word2[idx2])
                idx2 += 1
        return ''.join(ans)





