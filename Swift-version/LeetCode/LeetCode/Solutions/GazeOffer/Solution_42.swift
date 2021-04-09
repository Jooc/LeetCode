//
//  Solution_41.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/4/8.
//

import Foundation

class Solution_41: Solution{
    func main() {
        print(maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))
    }
    
    func maxSubArray(_ nums: [Int]) -> Int {
        var dp = nums[0]
        var res = dp
        
        for i in 1..<nums.count{
            dp = max(dp+nums[i], nums[i])
            res = max(dp, res)
        }
        return res
    }
}
