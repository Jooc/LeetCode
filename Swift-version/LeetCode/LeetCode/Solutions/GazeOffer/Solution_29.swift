//
//  Solution_29.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/4/1.
//

import Foundation

class Solution_29: Solution{
    func main() {
        print(spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12]]))
    }
    
    func spiralOrder(_ matrix: [[Int]]) -> [Int] {
        if matrix.count == 0 { return [] }
        var left = 0, right = matrix[0].count - 1, top = 0, bottom = matrix.count - 1
        
        var res:[Int] = []
        while true{
            // from left to right
            for i in left...right{ res.append(matrix[top][i]) }
            top += 1
            if top > bottom{break}
            
            // from top to bottom
            for i in top...bottom{res.append(matrix[i][right])}
            right -= 1
            if right < left {break}
            
            // from right to left
            for i in left...right{res.append(matrix[bottom][right + left - i ])}
            bottom-=1
            if bottom < top{break}
            
            // from bottom to top
            for i in top...bottom{res.append(matrix[bottom + top - i][left])}
            left += 1
            if left > right {break}
        }
        return res
    }
    
}
