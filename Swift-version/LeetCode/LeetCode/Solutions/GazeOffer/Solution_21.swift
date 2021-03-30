//
//  Solution_21.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/3/30.
//

import Foundation

class Solution_21: Solution{
    func main() {
        print(exchange([1,2,3,4]))
    }
    
    func exchange(_ nums: [Int]) -> [Int] {
        var nums = nums
        var left = nums.startIndex
        var right = nums.endIndex - 1
        while(left < right){
            while(left < right && nums[left] % 2 == 1){
                left = nums.index(after: left)
            }
            while(left < right && nums[right] % 2 == 0){
                right = nums.index(before: right)
            }
            nums.swapAt(left, right)
        }
        return nums
    }
}
