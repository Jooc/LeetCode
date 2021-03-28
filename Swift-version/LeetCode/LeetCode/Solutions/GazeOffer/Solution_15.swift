//
//  Solution_15.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/3/28.
//

import Foundation

class Solution_15: Solution {
    func main() {
        print(hammingWeight_0(00000000000000000000000000001011))
    }
    
//    func hammingWeight(_ n: Int) -> Int {
//        var count = 0, n = n
//        while(n != 0){
//            count+=1
//            n &= (n-1)
//        }
//        return count
//    }
    
    func hammingWeight_0(_ n: Int) -> Int {
        var count = 0, n = n
        while(n != 0){
            count += n & 1
            n /= 10
        }
        return count
    }
}
