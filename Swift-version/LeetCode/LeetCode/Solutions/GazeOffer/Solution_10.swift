//
//  Solution_10.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/3/26.
//

import Foundation

class Solution_10: Solution{
    func main() {
        print(fib(45))
    }
    
    // 10 - Ⅰ 斐波那契
    func fib(_ n: Int) -> Int {
        guard n > 1 else {
            return n
        }
        var a: Int = 0, b:Int = 1, c:Int = 1
        
        for _ in 2..<n{
            a = b
            b = c
            c = (a + b) % 1000000007
        }
        return c
    }
    
    // 10 - Ⅱ 跳台阶
    func numWays(_ n: Int) -> Int {
        guard n > 1 else {
            return 1
        }
        var a = 1, b = 1, c = 2
        for _ in 2..<n{
            a = b
            b = c
            c = (a + b) % 1000000007
        }
        return c
    }
}
