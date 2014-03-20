import java.util.ArrayList;
import java.util.Stack;


public class BinaryTreePreorderTraversal {
	public static void main(String[] argvs){
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		a.left=b;
		a.right=c;
		b.left=d;
		b.right=e;
		c.left=f;
		System.out.println(preorderTraversal(a).toString());
	}
	public static ArrayList<Integer> preorderTraversal(TreeNode root) {
		if(root==null)
    		return new ArrayList<Integer>();
    	
    	ArrayList<Integer> returnArray = new ArrayList<Integer>();
    	
        Stack<TreeNode> treeStack = new Stack<TreeNode>();
       
        treeStack.push(root);
        while(!treeStack.isEmpty()){
        	TreeNode tmp = treeStack.pop();
        	returnArray.add(tmp.val);
        	if(tmp.left==null&&tmp.right==null)
        		continue;
        	else if(tmp.left!=null&&tmp.right!=null){
	        	treeStack.push(tmp.right);
	        	treeStack.push(tmp.left);
        	}
        	else if(tmp.left==null){
        		treeStack.push(tmp.right);
        	}
        	else 
        		treeStack.push(tmp.left);
        }
        return returnArray; 
    }
}
