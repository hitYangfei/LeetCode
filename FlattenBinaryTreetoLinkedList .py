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
    def flatten(self, root):
        if root==None:
            return
        tmpList=[]
        self.dfs(root,tmpList)
        tmp = tmpList[0]
        root = tmpList[0]
        i=1
        while i<len(tmpList):
            tmp.right=tmpList[i]
            tmp.left=None
            tmp=tmp.right
            i+=1
       
    def dfs(self,root,tmpList):
        tmpList.append(root)
        if self.isLeaf(root):
            return
        if root.left!=None:
            self.dfs(root.left,tmpList)
        if root.right!=None:
            self.dfs(root.right,tmpList)
       
        
    def isLeaf(self,root):
        if root.left==None and root.right==None:
            return True
        return False

def printTree(root):
    if root==None:
        return
    print root.val
    if root.left==None:
        print '#'
    else:
        printTree(root.left)
    if root.right==None:
        print '#'
    else:
        printTree(root.right)
    
        
    
if __name__=="__main__":
    a = TreeNode(1)
    b = TreeNode(2)
   

    a.left = b
   

    s=Solution()
    s.flatten(a)
    printTree(a)
    

