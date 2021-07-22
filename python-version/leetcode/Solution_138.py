class Node:
    def __init__(self, x: int, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random


def printAll(head: Node):
    res = []
    while head is not None:
        res.append([head.next.val, head.random.val])
        head = head.next
    for nums in res:
        print(nums)


class Solution:
    def main(self):
        target = Node(7)
        target1 = Node(13)
        target2 = Node(11)
        target3 = Node(10)
        target4 = Node(1)
        target.next = target1
        target1.next = target2
        target2.next = target3
        target3.next = target4
        target1.random = target
        target2.random = target4
        target3.random = target2
        target4.random = target
        printAll(self.copyRandomList(target))

    def copyRandomList(self, head: Node) -> Node:
        res = Node(head.val)
        origin = head.next

        while origin is not None:
            current = Node(origin.val)
            res.next = current
            origin = origin.next
            print(current.val)

        return res
