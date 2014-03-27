# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @return an integer
    def minDepth(self, root):
        if root==None:
            return 0
        self.dfs(root,0)
        return self.currentMinDepth

    def dfs(self,root,minDepth):
        if self.isLeaf(root):
            tmp = minDepth+1
            if self.currentMinDepth==0:
                self.currentMinDepth=tmp
            else:
                if tmp<self.currentMinDepth:
                    self.currentMinDepth = tmp
        if root.left!=None:
            self.dfs(root.left,minDepth+1)
        if root.right!=None:
            self.dfs(root.right,minDepth+1)

    def isLeaf(self,root):
        if root.left==None and root.right==None:
            return True
        return False
        
    def __init__(self):
        self.currentMinDepth=0
if __name__=="__main__":
    a = TreeNode(1)
    b = TreeNode(1)
    c = TreeNode(1)
    d = TreeNode(1)
    e = TreeNode(1)
    a.left = b
    a.right=c
    b.left=d
    d.left=e
    s=Solution()
    print s.minDepth(a)
    
