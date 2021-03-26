//
//  Solution_12.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/3/26.
//

import Foundation

class Solution_12: Solution {
    func main() {
        <#code#>
    }
    
    func exist(_ board: [[Character]], _ word: String) -> Bool {
        let rows = board.count, cols = board[0].count
        
        let directions = [[0,1], [1,0], [0,-1], [-1,0]]
        let visited:[[Bool]] = Array(repeating: Array(repeating: false, count: cols), count: rows)
        
        func isInBoard(_ x: Int, _ y: Int) -> Bool{
            return x >= 0 && x < rows && y >= 0 && y < cols
        }
        
        for x in 0..<rows{
            for y in 0..<cols{
                var chCount = 1
                if board[x][y] == word.first{
                    while chCount < word.count{
                        for i in 0..<4{
                            let newX = x + directions[i][0]
                            let newY = y + directions[i][1]
                            
                            let index = word.index(word.startIndex, offsetBy: chCount)
                            guard isInBoard(newX, newY) else{
                                continue
                            }
                        }
                    }
                }
            }
        }
    }
}
