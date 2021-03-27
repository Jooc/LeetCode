//
//  Solution_12.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/3/26.
//

import Foundation

class Solution_12: Solution {
    func main() {
        print(exist([["a","a"]], "aaa"))
    }
    
    func exist(_ board: [[Character]], _ word: String) -> Bool {
        var board = board
        
        func isInBoard(_ x: Int, _ y: Int) -> Bool{
            return x >= 0 && x < board.count && y >= 0 && y < board[0].count
        }
        
        func dfs(_ x: Int, _ y: Int, _ word: String) -> Bool{
            guard word.count > 0 else {return true}
            guard isInBoard(x, y) && board[x][y] == word.first else {return false}
            
            board[x][y] = "\0"
            let wordAfterFirst = String(word.dropFirst())
            if dfs(x, y+1, wordAfterFirst) || dfs(x+1, y, wordAfterFirst) || dfs(x, y-1, wordAfterFirst) || dfs(x-1, y, wordAfterFirst){
                return true
            }
            board[x][y] = word.first!
            return false
        }
        
        for x in 0 ..< board.count{
            for y in 0 ..< board[0].count{
                if dfs(x, y, word){
                    return true
                }
            }
        }
        return false
    }

    func exist_0(_ board: [[Character]], _ word: String) -> Bool {
        let rows = board.count, cols = board[0].count

        let directions = [[0,1], [1,0], [0,-1], [-1,0]]
        var visited:[[Bool]] = Array(repeating: Array(repeating: false, count: cols), count: rows)

        func isInBoard(_ x: Int, _ y: Int) -> Bool{
            return x >= 0 && x < rows && y >= 0 && y < cols
        }
        
        func exist(_ x: Int, _ y: Int, word: String) -> Bool{
            if word.count == 0 {return true}
            
            for i in 0..<4{
                let newX = x + directions[i][0]
                let newY = y + directions[i][1]
                
                guard isInBoard(newX, newY) && !visited[newX][newY] else{
                    continue
                }
                
                if board[newX][newY] == word.first {
                    visited[newX][newY] = true
                    if exist(newX, newY, word: String(word.dropFirst())){
                        return true
                    }else{
                        visited[newX][newY] = false
                    }
                }
            }
            return false
        }

        for x in 0..<rows{
            for y in 0..<cols{
                if board[x][y] == word.first{
                    visited[x][y] = true
                    if exist(x, y, word: String(word.dropFirst())){
                        return true
                    }
                    visited[x][y] = false
                }
            }
        }
        return false
    }
    
    
    
}
