class Node:
    def __init__(self, val):
        self.val = val
        self.next = None


class MyLinkedList:

    def __init__(self):
        self.head = Node(-1)
        # self.tail = self.head
        self.len = 0

    def get(self, index: int) -> int:
        if index < 0 or index >= self.len:
            return -1

        cur = self.head
        for _ in range(index+1):
            cur = cur.next
        return cur.val


    def addAtHead(self, val: int) -> None:
        self.addAtIndex(0, val)

    def addAtTail(self, val: int) -> None:
        self.addAtIndex(self.len, val)

    def addAtIndex(self, index: int, val: int) -> None:
        if index > self.len:
            return
        cur = self.head
        for _ in range(index):
            cur = cur.next
        new_node = Node(val)
        new_node.next = cur.next
        cur.next = new_node
        self.len += 1

    def deleteAtIndex(self, index: int) -> None:
        if index < 0 or index >= self.len:
            return
        cur = self.head
        for _ in range(index):
            cur = cur.next
        cur.next = cur.next.next
        self.len -= 1

    def print_all(self):
        l = []
        cur = self.head.next
        while cur:
            l.append(cur.val)
            cur = cur.next
        print(l)


linkedList = MyLinkedList()
linkedList.addAtHead(1)
linkedList.print_all()
linkedList.addAtTail(3)
linkedList.print_all()
linkedList.addAtIndex(1,2)
linkedList.print_all()
print(linkedList.get(1))
linkedList.deleteAtIndex(1)
linkedList.print_all()
print(linkedList.get(1))