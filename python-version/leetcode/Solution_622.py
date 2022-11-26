class MyCircularQueue:

    def __init__(self, k: int):
        self.capacity, self.size = k, 0
        self.front = self.rear = 0
        self._q = [0] * self.capacity

    def enQueue(self, value: int) -> bool:
        if self.isFull():
            return False

        self.size += 1
        self._q[self.rear] = value
        self.rear = (self.rear + 1) % self.capacity
        return True

    def deQueue(self) -> bool:
        if self.isEmpty():
            return False

        self.front = (self.front + 1) % self.capacity
        self.size -= 1
        return True

    def Front(self) -> int:
        if self.isEmpty():
            return -1
        return self._q[self.front]

    def Rear(self) -> int:
        if self.isEmpty():
            return -1
        return self._q[(self.rear - 1) % self.capacity]

    def isEmpty(self) -> bool:
        return self.size == 0

    def isFull(self) -> bool:
        return self.size == self.capacity

# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue(k)
# param_1 = obj.enQueue(value)
# param_2 = obj.deQueue()
# param_3 = obj.Front()
# param_4 = obj.Rear()
# param_5 = obj.isEmpty()
# param_6 = obj.isFull()
