package yf.leetcode.clonegraph;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;



public class CloneGraph {
	public static void main(String[] argvs){
		UndirectedGraphNode tmp0 = new UndirectedGraphNode(0);
		UndirectedGraphNode tmp1 = new UndirectedGraphNode(1);
		UndirectedGraphNode tmp2 = new UndirectedGraphNode(2);
		tmp0.neighbors.add(tmp1);
		tmp0.neighbors.add(tmp2);
		tmp1.neighbors.add(tmp0);
		tmp1.neighbors.add(tmp2);
		tmp2.neighbors.add(tmp0);
		tmp2.neighbors.add(tmp1);
		tmp2.neighbors.add(tmp2);
		UndirectedGraphNode node = new CloneGraph().cloneGraph(tmp0);
		System.out.println(node.neighbors.get(1).label);
	}
	 public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		 if(node==null)
	    	 return null;
		 //已经clone的节点
	     Map<Integer,UndirectedGraphNode> hasClone = new Hashtable<Integer,UndirectedGraphNode>();
	     //已经被完全clone的原图中的节点，完全的意思是指邻居节点也被clone了
	     Map<Integer,UndirectedGraphNode> hasCloned = new Hashtable<Integer,UndirectedGraphNode>();
	     Stack<UndirectedGraphNode> nodeStack = new Stack<UndirectedGraphNode>(); 
	     nodeStack.push(node);
	     while(!nodeStack.isEmpty()){
	    	 UndirectedGraphNode tmp = nodeStack.pop();
	    	 if(hasCloned.get(tmp.label)!=null)
	    		 continue;
	    	 UndirectedGraphNode tmpClone = hasClone.get(tmp.label);
	    	 if(tmpClone==null){
	    		 tmpClone = new UndirectedGraphNode(tmp.label);
	    	 	 hasClone.put(tmpClone.label, tmpClone);
	    	 }
	    	 for(UndirectedGraphNode tmpSourceNode:tmp.neighbors){
	    		 if(hasCloned.get(tmpSourceNode.label)==null)
	    			 nodeStack.push(tmpSourceNode);
	    		 UndirectedGraphNode tmpCloneNode = hasClone.get(tmpSourceNode.label);
	    		 if(tmpCloneNode==null){
	    			 tmpCloneNode = new UndirectedGraphNode(tmpSourceNode.label);
	    			 hasClone.put(tmpCloneNode.label, tmpCloneNode);
	    		 }
	    		 tmpClone.neighbors.add(tmpCloneNode);
	    		 
	    	 }
	    	 hasCloned.put(tmp.label, tmp);
	     }
	     return hasClone.get(node.label);
	 }
	
	 
}
class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	@Override
	public String toString() {
		String str = ""+label+"neighbors:[";
		for(UndirectedGraphNode tmp:this.neighbors)
			str+=""+tmp.label+",";
		str+="]";
		return str;
	}
	
 }
