//
//  Solution_27.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/3/31.
//

import Foundation

class Solution_27: Solution {
    func main(){
        let target = TreeNode(4)
        target.left = TreeNode(2)
        target.right = TreeNode(7)
        target.left?.left = TreeNode(1)
        target.left?.right = TreeNode(3)
        target.right?.left = TreeNode(6)
        target.right?.right = TreeNode(9)
        
        let _ = mirrorTree(target)
        print(" ")
    }
    
    func mirrorTree(_ root: TreeNode?) -> TreeNode? {
        guard root != nil else { return nil }
        let tmp = root!.left
        root!.left = mirrorTree(root!.right)
        root!.right = mirrorTree(tmp)
        return root
    }
}
