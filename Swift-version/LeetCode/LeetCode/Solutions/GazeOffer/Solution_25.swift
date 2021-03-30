//
//  Solution_24.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/3/30.
//

import Foundation

class Solution_25: Solution {
    func main(){
        
    }
    
    func mergeTwoLists(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        var l1 = l1, l2 = l2
        let head = ListNode(-1)
        var cur = head
        
        while(l1 != nil && l2 != nil){
            if l1!.val <= l2!.val{
                cur.next = ListNode(l1!.val)
                l1 = l1?.next
            }else{
                cur.next = ListNode(l2!.val)
                l2 = l2?.next
            }
            cur = cur.next!
        }
        while l1 != nil{
            cur.next = ListNode(l1!.val)
            l1 = l1!.next
            cur = cur.next!
        }
        while l2 != nil{
            cur.next = ListNode(l2!.val)
            l2 = l2!.next
            cur = cur.next!
        }
        return head.next
    }
}
