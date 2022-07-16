from collections import deque

class MovingAverage:

    def __init__(self, size: int):
        """
        Initialize your data structure here.
        """
        self.size = size
        self.memory = deque([])


    def next(self, val: int) -> float:
        self.memory.append(val)
        if len(self.memory) > self.size:
            self.memory.popleft()
        return sum(self.memory) / len(self.memory)




# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param_1 = obj.next(val)