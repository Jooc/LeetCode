//
//  Solution_22.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/3/30.
//

import Foundation

class Solution_22: Solution{
    func main() {

    }
    
    func getKthFromEnd(_ head: ListNode?, _ k: Int) -> ListNode? {
        var slow = head
        var fast = head
        
        for _ in 0..<k{
            fast = fast!.next
        }
        
        while fast != nil{
            slow = slow?.next
            fast = fast?.next
        }
        return slow
    }
}
