//
//  Solution_8.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/3/25.
//

import Foundation

class Solution_9: Solution{
    func main() {
        let queue = CQueue()
        queue.appendTail(3)
        queue.appendTail(5)
        print(queue.deleteHead())
        print(queue.deleteHead())
    }
    
    class CQueue {
        
        var inStack: [Int] = []
        var outStack: [Int] = []

        init() { }
        
        func appendTail(_ value: Int) {
            inStack.append(value)
        }
        
        func deleteHead() -> Int {
            if outStack.isEmpty{
                outStack = inStack.reversed()
                inStack = []
            }
            return outStack.popLast() ?? -1
        }
    }
}
