class Solution:
    def main(self):
        print(self.findLUSlength("aaa", "aaa"))

    def findLUSlength(self, a: str, b: str) -> int:
        return max(len(a), len(b)) if len(a) + len(b) > 0 else -1
