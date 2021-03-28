//
//  Solution_17.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/3/28.
//

import Foundation

class Solution_17: Solution {
    func main() {
        print(printNumbers(3))
    }
    
    // 不考虑大数
    func printNumbers_0(_ n: Int) -> [Int] {
        return [Int](1..<Int(pow(10, Double(n))))
    }
    
    func printNumbers(_ n: Int) -> String{
        var res: String = ""
        let numChars = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
        var builder = ""
        print(builder[(builder.firstIndex(of: "0") ?? builder.startIndex)...])
        
        func dfs(_ x: Int){
            if x == n{
                let begin = builder.first == "0" ? builder.index(after: builder.lastIndex(of: "0")!) : builder.startIndex
                res.append(builder[(begin == builder.endIndex ? builder.index(before: builder.endIndex) : begin)...] + ",")
                return
            }
            for ch in numChars {
                builder.append(ch)
                dfs(x+1)
                builder.removeLast()
            }
        }
        
        dfs(0)
        return String(res.dropLast())
    }
}
