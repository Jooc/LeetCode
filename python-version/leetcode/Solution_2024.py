class Solution:
    def maxConsecutiveAnswers(self, answerKey: str, k: int) -> int:
        def maxWithLetter(c):
            ans, sum, left = 0, 0, 0
            for right in range(len(answerKey)):
                sum += answerKey[right] != c
                while sum > k:
                    sum -= answerKey[left] != c
                    left += 1
                ans = max(ans, right - left + 1)
            return ans
        return max(maxWithLetter('T'), maxWithLetter('F'))
