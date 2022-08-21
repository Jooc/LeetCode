class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        for i, word in enumerate(sentence.split(' ')):
            if word.startswith(searchWord):
                return i + 1
        return -1

solution = Solution()
print(solution.isPrefixOfWord("this problem is an easy problem", "pro"))
# print(solution.isPrefixOfWord("i love this burger", "burg"))