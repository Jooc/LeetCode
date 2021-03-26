//
//  Solution_11.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/3/26.
//

import Foundation

class Solution_11: Solution {
    func main() {
        print(minArray([3,0,1,1,1,1,1]))
    }
    
    func minArray(_ numbers: [Int]) -> Int {
        var left = 0, right = numbers.count-1
        while(left < right){
            let mid = (left+right)/2
            if numbers[mid] > numbers[right]{
                left = mid + 1
            }else if numbers[mid] < numbers[right]{
                right = mid
            }
            else{
                right -= 1
            }
        }
        return numbers[left]
    }
}
