# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None

class Solution:
    # @param root, a tree node
    # @return nothing
class Solution:
    # @param root, a tree node
    # @return nothing
    def connect(self, root):
        if root==None:
            return None
        if root.left==None and root.right==None:
            root.next=None
            return 
        listmp=[]
        listmp.append(root)
        while len(listmp)!=0:
            lista=[]
            i=0
            while i<(len(listmp)-1):
                listmp[i].next=listmp[i+1]
                lista.append(listmp[i].left)
                lista.append(listmp[i].right)
                i+=1
            listmp[i].next=None
            lista.append(listmp[i].left)
            lista.append(listmp[i].right)
            if lista[0]==None:
                break
            listmp=lista

if __name__=="__main__":
    a1=TreeNode(1)
    a2=TreeNode(2)
    a3=TreeNode(3)
    a4=TreeNode(4)
    a5=TreeNode(5)
    a6=TreeNode(6)
    a7=TreeNode(7)
    a8=TreeNode(8)
    a1.left=a2
    a1.right=a3
    a2.left=a4
    a2.right=a5
    a3.left=a6
    a3.right=a7
    s=Solution()
    s.connect(a1)
    
            
                
                
            
        
        
