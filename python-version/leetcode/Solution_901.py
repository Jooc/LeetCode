import bisect


class StockSpanner:

    def __init__(self):
        self.stack = [(-1, inf)]
        self.idx = -1

    def next(self, price: int) -> int:
        self.idx += 1
        while price >= self.stack[-1][1]:
            self.stack.pop()
        self.stack.append((self.idx, price))
        return self.idx - self.stack[-2][0]



s = StockSpanner()
s.next(29)
s.next(91)
s.next(62)
s.next(76)
s.next(51)
# s.next(75)
# s.next(85)

# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)
