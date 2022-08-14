class Solution:
    def maxScore_0(self, s: str) -> int:
        max_score = score = (s[0] == '0') + s[1:].count('1')

        for i in range(1, len(s)-1):
            score += 1 if s[i] == '0' else -1
            max_score = max(score, max_score)

        return max_score

    def maxScore(self, s: str) -> int:
        return max(s[:i].count('0') + s[i:].count('1') for i in range(1, len(s)))


