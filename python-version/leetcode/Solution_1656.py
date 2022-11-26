from typing import List


class OrderedStream:

    def __init__(self, n: int):
        self.elements = [''] * (n + 1)
        self.ptr = 1

    def insert(self, idKey: int, value: str) -> List[str]:
        ans = []

        self.elements[idKey] = value
        if self.ptr == idKey:
            while self.ptr < len(self.elements) and self.elements[self.ptr] != '':
                ans.append(self.elements[self.ptr])
                self.ptr += 1

        return ans



# Your OrderedStream object will be instantiated and called as such:
# obj = OrderedStream(n)
# param_1 = obj.insert(idKey,value)
