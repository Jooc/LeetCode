//
//  Solution_18.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/3/29.
//

import Foundation

class Solution_18: Solution{
    func main() {
        
    }
    
    func deleteNode(_ head: ListNode?, _ val: Int) -> ListNode? {
        if head?.val == val{
            return head?.next
        }
        
        var pre = head
        while let next = pre?.next{
            if next.val == val {
                pre?.next = next.next
                return head
            }
            pre = pre?.next
        }
        return head
    }
}
