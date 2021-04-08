//
//  Solution_40.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/4/2.
//

import Foundation

class Solution_40: Solution {
    func main() {
        print(getLeastNumbers([3,2,1], 2))
    }

    func getLeastNumbers(_ arr: [Int], _ k: Int) -> [Int] {
        var arr = arr
        quickSort(&arr, 0, arr.count - 1)
        return Array(arr[..<k])
    }
    
    func quickSort(_ arr: inout [Int], _ left: Int, _ right: Int){
        if left < right{
            let index = partition(&arr, left, right: right)
            quickSort(&arr, left, index - 1)
            quickSort(&arr, index + 1, right)
        }
    }
    
    func partition(_ arr: inout [Int], _ left: Int, right: Int) -> Int{
        var left = left, right = right
        let pivot = arr[left]
        while left < right{
            while left < right && arr[left] < pivot {left += 1}
            while left < right && arr[right] > pivot {right -= 1}
            arr.swapAt(left, right)
        }
        arr[left] = pivot
        return left
    }
    
}
