//
//  Solution_3.swift
//  LeetCode-Swift
//
//  Created by 齐旭晨 on 2021/3/21.
//

import Foundation

class Solution_0: Solution {
    func main() {
        print(findRepeatNumber([2, 3, 1, 0, 2, 5, 3]))
    }
    
    func findRepeatNumber_0(_ nums: [Int]) -> Int {
        return nums.duplicate()[0]
    }
    
    func findRepeatNumber_1(_ nums: [Int]) -> Int {
        var set: Set<Int> = [];
        for num in nums{
            if set.contains(num){
                return num
            }
            set.insert(num)
        }
        return -1
    }
    
    func findRepeatNumber(_ nums: [Int]) -> Int {
        var nums = nums;
        
        for i in 0 ..< nums.count{
            if(nums[i] == i) {continue}
            if(nums[i] == nums[nums[i]]) {return nums[i]}
            nums.swapAt(nums[i], nums[nums[i]])
        }
        return -1
    }
    
}

// 邪道
// Time 5.63%
// Space 33.44%
extension Sequence where Element: Hashable{
    func duplicate() -> [Element]{
        var seen: Set<Element> = []
        return filter{element in
            if(seen.contains(element)){
                return true
            }else{
                seen.insert(element)
                return false
            }
        }
    }
}
