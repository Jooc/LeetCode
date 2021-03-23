//
//  Solution_5.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/3/23.
//

import Foundation

class Solution_5: Solution{
    func main() {
        print(replaceSpace("We are happy."))
    }
    
    func replaceSpace(_ s: String) -> String {
        return s.reduce("") {str, ch in
            if ch == " "{
                return str + "%20"
            }
            return str + String(ch)
        }
    }
}
