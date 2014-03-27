# Definition for a  binary tree node

import math
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @return a boolean
    def isBalanced(self, root):
        self.checkBalanced(root)
        return self.isBalancedTree

    def checkBalanced(self,root):
      
        if root==None:
            return -1
        leftDep = self.checkBalanced(root.left)+1
        rightDep = self.checkBalanced(root.right)+1
        if math.fabs(leftDep-rightDep)>1:
            self.isBalancedTree=False
        return max(leftDep,rightDep)
        
    def __init__(self):
        self.isBalancedTree=True

if __name__=="__main__":
    a = TreeNode(1)
    b = TreeNode(2)
    c = TreeNode(3)


    
    a.right=b

    b.right=c
   
    s = Solution()
    print s.isBalanced(a)
    
