package yf.leetcode;

public class SumRoottoLeafNumbers {
	private static int sum=0;
	public static void main(String[] argvs){
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		//TreeNode node2 = new TreeNode(3);
		root.right=node1;
		//root.right=node2;
		new SumRoottoLeafNumbers().sumNumbers(root);
		System.out.println(sum);
	}
	public int sumNumbers(TreeNode root) {
		sum=0;
		if(root==null)
			return 0;
		traverseTree(root,0);
	    return sum;
	}
	private void traverseTree(TreeNode currentTreeNode,int currentSum){
		currentSum*=10;
		currentSum += currentTreeNode.val;
		if(isLeaf(currentTreeNode)){
			sum+=currentSum;
			return;
		}
		
		if(currentTreeNode.left!=null)
			traverseTree(currentTreeNode.left,currentSum);
		if(currentTreeNode.right!=null)
			traverseTree(currentTreeNode.right,currentSum);
	}
	private boolean isLeaf(TreeNode currentTreeNode){
		if(currentTreeNode.left==null
				&&currentTreeNode.right==null)
			return true;
		return false;
	}
	 
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
   	TreeNode(int x) { val = x; }
	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
   
 }

