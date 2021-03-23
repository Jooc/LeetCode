//
//  Solution_118.swift
//  LeetCode-Swift
//
//  Created by 齐旭晨 on 2021/3/22.
//

import Foundation

class Solution_118: Solution{
    func main() {
        print(generate(5))
    }
    
    func generate(_ numRows: Int) -> [[Int]] {
        var res:[[Int]] = [[]]
        
        for i in 0 ..< numRows{
            var current:[Int] = []
            for j in 0 ... i{
                if(j == 0 || j == i){
                    current.append(1)
                }else{
                    current.append(res[i][j] + res[i][j-1])
                }
            }
            res.append(current)
            print(current)
        }
        
        return Array(res.dropFirst())
    }
}
