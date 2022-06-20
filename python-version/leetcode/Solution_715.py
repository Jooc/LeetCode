from bisect import bisect_right
from sortedcontainers import SortedDict


class RangeModule:

    def __init__(self):
        self.borders = SortedDict()

    def addRange(self, left: int, right: int) -> None:
        itvs = self.borders
        x = itvs.bisect_right(left)
        if x != 0:
            start = x - 1
            if itvs.values()[start] >= right:
                return
            if itvs.values()[start] >= left:
                left = itvs.keys()[start]
                itvs.popitem(start)
                x -= 1
        while x < len(itvs) and itvs.keys()[x] <= right:
            right = max(right, itvs.values()[x])
            itvs.popitem(x)

        itvs[left] = right

    def queryRange(self, left: int, right: int) -> bool:
        itvs_ = self.intervals

        x = itvs_.bisect_right(left)
        if x == 0:
            return False

        return right <= itvs_.values()[x - 1]

    def removeRange(self, left: int, right: int) -> None:
        itvs_ = self.intervals

        x = itvs_.bisect_right(left)
        if x != 0:
            start = x - 1
            if (ri := itvs_.values()[start]) >= right:
                if (li := itvs_.keys()[start]) == left:
                    itvs_.popitem(start)
                else:
                    itvs_[li] = left
                if right != ri:
                    itvs_[right] = ri
                return
            elif ri > left:
                itvs_[itvs_.keys()[start]] = left

        while x < len(itvs_) and itvs_.keys()[x] < right:
            if itvs_.values()[x] <= right:
                itvs_.popitem(x)
            else:
                itvs_[right] = itvs_.values()[x]
                itvs_.popitem(x)
                break

# Your RangeModule object will be instantiated and called as such:
# obj = RangeModule()
# obj.addRange(left,right)
# param_2 = obj.queryRange(left,right)
# obj.removeRange(left,right)
