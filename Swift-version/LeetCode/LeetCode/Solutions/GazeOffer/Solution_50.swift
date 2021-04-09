//
//  Solution_50.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/4/9.
//

import Foundation

class Solution_50: Solution{
    func main() {
        print(firstUniqChar("leetcode"))
    }
    
    func firstUniqChar(_ s: String) -> Character {
        var counter:[Character: Bool] = [:]
        
        for ch in s{
            if counter[ch] == nil{
                counter[ch] = true
            }else{
                counter[ch] = false
            }
        }
        for ch in s{
            if counter[ch]! {
                return ch
            }
        }
        return " "
    }
}
