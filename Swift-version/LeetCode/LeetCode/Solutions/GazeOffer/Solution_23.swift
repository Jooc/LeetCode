//
//  Solution_23.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/3/30.
//

import Foundation

class Solution_23: Solution{
    func main() {
        
    }
    
    func reverseList(_ head: ListNode?) -> ListNode? {
        var res: ListNode? = nil
        var node = head
        
        while node != nil{
            let new = ListNode(node!.val)
            new.next = res
            res = new
            node = node?.next
        }
        return res
    }
}
