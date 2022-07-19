class MyCalendarTwo:

    def __init__(self):
        self.booked = []
        self.overlaps = []

    def book(self, start: int, end: int) -> bool:
        if any(i < end and start < j for i, j in self.overlaps):
            return False
        for i, j in self.booked:
            if i < end and start < j:
                self.overlaps.append((max(i, start), min(j, end)))
        self.booked.append((start, end))
        return True



# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(start,end)