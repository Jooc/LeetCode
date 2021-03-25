//
//  Solution_7.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/3/25.
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

class Solution_7: Solution {
    
    func main() {
        let tree = buildTree([3,9,20,15,7], [9,3,15,20,7])
        tree?.printByLeverOrder()
    }
    
    
    func buildTree(_ preorder: [Int], _ inorder: [Int]) -> TreeNode? {
        return build(preorder, inorder, 0, preorder.count-1, 0, inorder.count-1)
    }
     
    func build(_ preorder:[Int], _ inorder:[Int], _ preBegin: Int, _ preEnd: Int, _ inBegin: Int, _ inEnd: Int) -> TreeNode? {
        if preBegin > preEnd || inBegin > inEnd{
            return nil
        }
        
        let node = TreeNode(preorder[preBegin])
        
        let rootIndex = inorder.firstIndex(of: preorder[preBegin])
        let leftLen = rootIndex! - inBegin
        node.left = build(preorder, inorder, preBegin+1, preBegin + 1 + leftLen, inBegin, rootIndex!-1)
        node.right = build(preorder, inorder, preBegin+leftLen+1, preEnd, rootIndex!+1, inEnd)
        
        return node
    }
}
