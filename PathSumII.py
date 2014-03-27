# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @param sum, an integer
    # @return a boolean
    def pathSum(self, root, sum):
        if root==None:
            return []
        self.sum=sum
        tmpList=[]
      
        self.dfs(root,0,tmpList)
        return self.list
    def dfs(self,root,currentSum,tmpList):
        tmpList.append(root.val)
        if self.isLeaf(root):
            if currentSum+root.val==self.sum:
                self.list.append(tmpList[:])
        if root.left!=None:
            self.dfs(root.left,currentSum+root.val,tmpList)
        if root.right!=None:
            self.dfs(root.right,currentSum+root.val,tmpList)
        tmpList.pop()
        
    def isLeaf(self,root):
        if root.left==None and root.right==None:
            return True
        return False

    def __init__(self):
        self.sum=0
        self.list=[]

if __name__=="__main__":
    a = TreeNode(1)
    b = TreeNode(2)
    c = TreeNode(3)
    d = TreeNode(4)
    e = TreeNode(5)

    a.left = b
    a.right=c
    b.left=d
    d.left=e

    s=Solution()
    print s.pathSum(a,12)
    

