//
//  Solution_39.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/4/2.
//

import Foundation

class Solution_39: Solution{
    func main() {
        print(majorityElement([1, 2, 3, 2, 2, 2, 5, 4, 2]))
    }
    
    func majorityElement(_ nums: [Int]) -> Int {
        var res: Int = nums[0]
        var score = 0
        for num in nums{
            if score == 0{
                res = num
            }
            if num == res{
                score += 1
            }else{
                score -= 1
            }
        }
        return res
    }
}
