# Definition for a Node.
class Node:
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next


class Solution:
    def insert(self, head: 'Node', insertVal: int) -> 'Node':
        new_node = Node(insertVal)
        if head is None:
            new_node.next = new_node
            return new_node

        res = Node(-1, head)
        if head.val == insertVal:
            new_node.next = head.next
            head.next = new_node
            return head

        curr = head
        next = head.next
        while next != head:
            if curr.val <= insertVal < next.val:
                break
            if next.val < curr.val:
                if insertVal > curr.val or insertVal < next.val:
                    break
            curr = curr.next
            next = next.next

        curr.next = new_node
        new_node.next = next

        return head
