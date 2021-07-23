class Node:
    def __init__(self, x: int, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random


def printAll(head: Node):
    res = []
    while head is not None:
        single = [head.val]
        if head.random is not None:
            single.append(head.random.val)
        else:
            single.append(None)
        res.append(single)
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
        if not head:
            return

        res = Node(head.val)
        res.next = head.next
        head.next = res

        origin = res.next
        while origin is not None:
            current = Node(origin.val)
            current.next = origin.next
            origin.next = current

            origin = current.next

        origin = head
        while origin is not None:
            if origin.random is not None:
                origin.next.random = origin.random.next
            origin = origin.next.next

        origin = head
        guard = Node(-1, None, None)
        current = guard
        while origin is not None:
            current.next = origin.next
            origin = origin.next.next
            current = current.next

        return guard.next
