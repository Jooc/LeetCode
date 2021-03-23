//
//  Solution_4.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/3/23.
//

import Foundation

class Solution_4: Solution{
    func main() {
        print(findNumberIn2DArray([
            [1,   4,  7, 11, 15],
            [2,   5,  8, 12, 19],
            [3,   6,  9, 16, 22],
            [10, 13, 14, 17, 24],
            [18, 21, 23, 26, 30]
          ], 15))
    }
    
    func findNumberIn2DArray(_ matrix: [[Int]], _ target: Int) -> Bool {
        let rows = matrix.count, cols = matrix[0].count
        var x = 0, y = cols - 1

        while(x < rows && y >= 0){
            if target == matrix[x][y] {
                return true
            }else if target > matrix[x][y]{
                x+=1
            }else{
                y-=1
            }
        }
        return false
    }
}
