from typing import List


class Trie:
    def __init__(self):
        self.children = [None] * 26
        self.is_end = False

    def insert(self, word: str):
        node = self
        for ch in word:
            ch = ord(ch) - ord('a')
            if not node.children[ch]:
                node.children[ch] = Trie()
            node = node.children[ch]
        node.is_end = True

    def search(self, word: str) -> bool:
        node = self
        for ch in word:
            ch = ord(ch) - ord('a')
            if node.children[ch] is None or not node.children[ch].is_end:
                return False
            node = node.children[ch]
        return True


class Solution:
    def main(self):
        print(self.longestWord(["a", "banana", "app", "appl", "ap", "apply", "apple"]))

    def longestWord_0(self, words: List[str]) -> str:
        words.sort(key=lambda x: (-len(x), x), reverse=True)

        ans, evolution = "", {""}
        for word in words:
            if word[:-1] in evolution:
                ans = word
                evolution.add(word)

        return ans

    def longestWord(self, words: List[str]) -> str:
        tree = Trie()
        for word in words:
            tree.insert(word)
        ans = ""
        for word in words:
            if tree.search(word) and (len(word) > len(ans) or len(word) == len(ans) and word < ans):
                ans = word
        return ans
