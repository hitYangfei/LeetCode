import java.util.ArrayList;
import java.util.Stack;



public class BinaryTreePostorderTraversal {
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
		System.out.println(postorderTraversal(a).toString());
	}
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
    	if(root==null)
    		return new ArrayList<Integer>();;
    	
    	ArrayList<Integer> returnArray = new ArrayList<Integer>();
    	
        Stack<TreeNode> treeStack = new Stack<TreeNode>();
        ArrayList<TreeNode> hasBeenPrint = new ArrayList<TreeNode>();
        treeStack.push(root);
        while(!treeStack.isEmpty()){
        	TreeNode tmp = treeStack.peek();
        	if(tmp.left==null&&tmp.right==null){
        		returnArray.add(tmp.val);
        		hasBeenPrint.add(tmp);
        		treeStack.pop();
        	}
        	else if(tmp.left!=null&&tmp.right!=null){
        		if(hasBeenPrint.contains(tmp.left)&&hasBeenPrint.contains(tmp.right)){
        			returnArray.add(tmp.val);
        			hasBeenPrint.remove(tmp.left);
        			hasBeenPrint.remove(tmp.right);
        			hasBeenPrint.add(tmp);
            		treeStack.pop();
        		}
        		else{
        			treeStack.push(tmp.right);
        			treeStack.push(tmp.left);
        		}
        	}
        	else if(tmp.left==null){
        		if(hasBeenPrint.contains(tmp.right)){
        			returnArray.add(tmp.val);
        			hasBeenPrint.remove(tmp.right);
        			hasBeenPrint.add(tmp);
            		treeStack.pop();
        		}
        		else{
        			treeStack.push(tmp.right);
        		
        		}
        	}
        	else{
        		if(hasBeenPrint.contains(tmp.left)){
        			returnArray.add(tmp.val);
        			hasBeenPrint.remove(tmp.left);
        			hasBeenPrint.add(tmp);
            		treeStack.pop();
        		}
        		else{
        			treeStack.push(tmp.left);
        		
        		}
        	}
        	
        }
        return returnArray;
    }
    public static boolean isLeaf(TreeNode node){
    	if(node.left==null&&node.right==null)
    		return true;
    	return false;
    }
}
class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; this.left=null;this.right=null;}
	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right
				+ "]";
	}
	 
}