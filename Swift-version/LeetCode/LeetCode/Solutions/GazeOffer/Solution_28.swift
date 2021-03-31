//
//  Solution_28.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/3/31.
//

import Foundation

class Solution_28: Solution {
    func main() {
        let target = TreeNode(1)
        target.left = TreeNode(2)
        target.right = TreeNode(2)
        target.left?.left = TreeNode(3)
        target.left?.right = TreeNode(4)
        target.right?.left = TreeNode(4)
        target.right?.right = TreeNode(3)
        
        let isS = isSymmetric(target)
        print(isS)
    }
    
    func isSymmetric(_ root: TreeNode?) -> Bool {
        return root == nil || recur(root?.left, root?.right)
    }
    
    func recur(_ left: TreeNode?, _ right: TreeNode?) -> Bool{
        if left == nil || right == nil {
            return left == nil && right == nil && left?.val == right?.val
        }
        return (left!.val == right!.val) && recur(left!.left, right!.right) && recur(left!.right, right!.left)
    }
}
