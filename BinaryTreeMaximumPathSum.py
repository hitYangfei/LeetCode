# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @return an integer
    def __init__(self):
        self.currentMaxSum=0
 
    def maxPathSum(self, root):
        if root == None :
            return 0
        self.currentMaxSum=root.val
        maxSum = self.dfs(root)
        return max(self.currentMaxSum,maxSum)

        
    def dfs(self, root):  
        if root==None:
            return 0
        left = self.dfs(root.left)
        right = self.dfs(root.right)
        sumTmp = root.val
        if left>0:
            sumTmp +=left
        if right>0:
            sumTmp +=right
        self.currentMaxSum = max(self.currentMaxSum,sumTmp )
        return max(root.val,max(root.val+left,root.val+right))
        
    

if __name__=="__main__":
    a=TreeNode(-1)
    b=TreeNode(-2)
    c=TreeNode(-3)
    a.left=b
    a.right=c
    s = Solution()
    print s.maxPathSum(a)
