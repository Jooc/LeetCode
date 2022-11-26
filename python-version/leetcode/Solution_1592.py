class Solution:
    def reorderSpaces(self, text: str) -> str:
        words = text.split()

        n_word = len(words)
        n_space = text.count(' ')

        if n_word == 1:
            return "".join([words[0], ' ' * n_space])

        return (' ' * (n_space // (n_word - 1))).join(words) + (' ' * (n_space % (n_word - 1)))


solution = Solution()
print(solution.reorderSpaces("  this   is  a sentence "))
