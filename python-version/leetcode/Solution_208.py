class Trie:

    def __init__(self):
        self.children = [None] * 26
        self.is_end = False

    def insert(self, word: str) -> None:
        node = self
        for c in word:
            c_index = ord(c) - ord('a')
            if not node.children[c_index]:
                node.children[c_index] = Trie()
            node = node.children[c_index]
        node.is_end = True

    def search_prefix(self, prefix):
        node = self
        for ch in prefix:
            c_index = ord(ch) - ord('a')
            if not node.children[c_index]:
                return None
            node = node.children[c_index]
        return node

    def search(self, word: str) -> bool:
        node = self.search_prefix(word)
        return node is not None and node.is_end

    def startsWith(self, prefix: str) -> bool:
        return self.search_prefix(prefix) is not None



# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)