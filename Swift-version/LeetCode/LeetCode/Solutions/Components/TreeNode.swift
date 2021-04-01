//
//  TreeNode.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/4/1.
//

import Foundation

public class TreeNode{
    public var val: Int
    public var left: TreeNode?
    public var right: TreeNode?
    
    init(_ val: Int) {
        self.val = val
        self.left = nil
        self.right = nil
    }
    
    func printByLeverOrder(){
        var queue:[TreeNode] = [self]
        while !queue.isEmpty{
            let node = queue.removeFirst()
            print(node.val)
            
            if node.left != nil{
                queue.append(node.left!)
            }
            if node.right != nil{
                queue.append(node.right!)
            }
        }
    }
}
