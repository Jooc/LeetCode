from collections import deque


class RecentCounter_0:
    def __init__(self):
        self.history = []

    def ping(self, t: int) -> int:
        self.history.append(t)
        index, count = len(self.history) - 1, 0
        while index >= 0 and self.history[index] >= t - 3000:
            count += 1
            index -= 1
        return count

class RecentCounter:
    def __init__(self):
        self.history = deque()

    def ping(self, t: int) -> int:
        self.history.append(t)
        while self.history[0] < t-3000:
            self.history.popleft()
        return len(self.history)


# Your RecentCounter object will be instantiated and called as such:
obj = RecentCounter()
print(obj.ping(1))
print(obj.ping(100))
print(obj.ping(3001))
print(obj.ping(3002))