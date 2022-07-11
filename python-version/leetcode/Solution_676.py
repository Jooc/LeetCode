from typing import List

class MagicDictionary:

    def __init__(self):
        self._dictionary = []

    def buildDict(self, dictionary: List[str]) -> None:
        self._dictionary = dictionary

    def search(self, searchWord: str) -> bool:
        for word in self._dictionary:
            if len(word) != len(searchWord):
                continue
            diff = 0
            for cx, cy in zip(word, searchWord):
                if cx != cy:
                    diff+=1
                    if diff > 1:
                        break

            if diff == 1:
                return True

        return False


# Your MagicDictionary object will be instantiated and called as such:
# obj = MagicDictionary()
# obj.buildDict(dictionary)
# param_2 = obj.search(searchWord)