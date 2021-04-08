//
//  Solution_32.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/4/1.
//

import Foundation

class Solution_32_1: Solution{
    func main() {
        
    }
    
    func levelOrder(_ root: TreeNode?) -> [Int] {
        var res: [Int] = []
        if root == nil { return res }
        var queue: [TreeNode] = []
        queue.append(root!)

        while(queue.count != 0){
            let node = queue.removeFirst()
            res.append(node.val)

            if node.left != nil{
                queue.append(node.left!)
            }
            if node.right != nil{
                queue.append(node.right!)
            }
            
        }
        return res
    }
}

class Solution_32_2: Solution {
    func main() {
        let target = TreeNode(3)
        target.left = TreeNode(9)
        target.right = TreeNode(20)
        target.right?.left = TreeNode(15)
        target.right?.right = TreeNode(7)
        
        print(levelOrder(target))
    }
    
    func levelOrder(_ root: TreeNode?) -> [[Int]] {
        var res:[[Int]] = []
        if root == nil {return res}
        
        var queue: [TreeNode] = [root!]
        while queue.count != 0{
            let nodes = queue
            queue.removeAll()
            
            res.append(nodes.map{ (node: TreeNode) -> Int in
                if node.left != nil {queue.append(node.left!)}
                if node.right != nil {queue.append(node.right!)}
                
                return node.val
            })
        }
        
        return res
    }
}

class Solution_32_3: Solution {
    func main() {
            
    }
    
    func levelOrder(_ root: TreeNode?) -> [[Int]] {
        var res:[[Int]] = []
        if root == nil {return res}
        
        var queue: [TreeNode] = [root!]
        var lever = 1
        while queue.count != 0{
            let nodes = queue
            queue.removeAll()
            
            let list = (nodes.map{ (node: TreeNode) -> Int in
                if node.left != nil {queue.append(node.left!)}
                if node.right != nil {queue.append(node.right!)}
                
                return node.val
            })
            
            res.append(lever % 2 == 0 ? list.reversed() : list)
            lever += 1
        }
        
        return res
    }
}
