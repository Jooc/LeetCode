from typing import List


class Solution:
    def main(self):
        print(self.findClosest(["I","am","a","student","from","a","university","in","a","city"], "a", "student"))
    def findClosest_0(self, words: List[str], word1: str, word2: str) -> int:
        index1, index2 = -1, -1
        ans = len(words)
        for i, word in enumerate(words):
            if word == word1:
                index1 = i
            elif word == word2:
                index2 = i
            if index1 >= 0 and index2 >= 0:
                ans = min(ans, abs(index2 - index1 - 1))

        return ans

    def findClosest(self, words: List[str], word1: str, word2: str) -> int:
        index_of_word = dict()
        for i, word in enumerate(words):
            if word not in index_of_word:
                index_of_word[word] = [i]
            else:
                index_of_word[word].append(i)

        ans =  [abs(y - x) for y in index_of_word[word1] for x in index_of_word[word2]]
        print(ans)

        return min(ans)

solution = Solution()
solution.main()