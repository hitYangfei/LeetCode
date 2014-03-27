# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
#Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
class Solution:
    # @param head, a list node
    # @return a tree node
    def sortedListToBST(self, head):
        if head==None:
            return None
        num=[]
        p=head
        while p!=None:
            num.append(p.val)
            p=p.next
        return self.sortedArrayToBST(num)
    def sortedArrayToBST(self, num):
        if num==None or len(num)==0:
            return None
        return self.dfsBuildBST(num,0,len(num)-1)
    def dfsBuildBST(self,num,begin,end):
        if begin>end:
            return None
        if begin==end:
            return TreeNode(num[begin])
        middle=(begin+end)/2
        tmpNode = TreeNode(num[middle])
        leftNode = self.dfsBuildBST(num,begin,middle-1)
        rightNode = self.dfsBuildBST(num,middle+1,end)
        tmpNode.left=leftNode
        tmpNode.right=rightNode
        return tmpNode

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
    num=[1,2,3,4,5,6,7,8]
    s=Solution()
    printTree(s.sortedArrayToBST(num))
        
        
    
