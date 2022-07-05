class MyCalendar:
    def __init__(self):
        self.schedule = []

    def book(self, start: int, end: int) -> bool:
        if any(end > l and start < r for l, r in self.schedule):
            return False
        self.schedule.append((start, end))
        return True


# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)