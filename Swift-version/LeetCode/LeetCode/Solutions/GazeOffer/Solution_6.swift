//
//  Solution_6.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/3/24.
//

import Foundation

class ListNode {
    public var val: Int
    public var next: ListNode?
    
    public init(_ val: Int) {
        self.val = val
        self.next = nil
    }
}

class Solution_6: Solution{
    func main() {
        
        let target = ListNode(1)
        target.next = ListNode(2)
        target.next?.next = ListNode(3)
        
        print(reversePrint(target))
    }
    
    func reversePrint(_ head: ListNode?) -> [Int] {
        var res:[Int] = []
        
        if  var node = head{
            res.append(node.val)
            while node.next != nil{
                node = node.next!
                res.append(node.val)
            }
        }
        
        return res.reversed()
    }
    
}
