package yf.leetcode.randomlink;


import java.util.Hashtable;
import java.util.Map;

public class RandomLink{
	public static void main(String[] argvs){
		RandomListNode a1 = new RandomListNode(1);
		RandomListNode a2 = new RandomListNode(2);
		RandomListNode a3 = new RandomListNode(3);
		RandomListNode a4 = new RandomListNode(4);
		a1.next=a2;
		a1.random=a3;
		a2.next=a3;
		a2.random=a1;
		a3.next=a4;
		a3.random=null;
		a4.next=null;
		a4.random=null;
		
		
		RandomListNode head = new RandomLink().copyRandomList(a1);
		RandomListNode p = head;
		while(p!=null){
			System.out.print(p.label);
			if(p.random!=null)
				System.out.print("random:"+p.random.label);
			if(p.next!=null)
				System.out.print("next:"+p.next.label+"\n");
			p=p.next;
		}
	}
	public RandomListNode copyRandomList(RandomListNode head) {
	     if(head==null)
	    	 return null;
	     RandomListNode tmpResult = new RandomListNode(0);
	     RandomListNode q  = tmpResult;
	    
	     RandomListNode tmp = new RandomListNode(0);
	     tmp.next=head;
	     Map<Integer,RandomListNode> hasCopyNodes = new Hashtable<Integer,RandomListNode>();
	     while(tmp.next!=null){
	    	 RandomListNode p = tmp.next;
	    	 RandomListNode copyNode = isHasCopy(hasCopyNodes,p.label);
	    	
	    	 if(p.random!=null){
	    		 RandomListNode copyNodeRandom =  isHasCopy(hasCopyNodes,p.random.label);
	    		 copyNode.random = copyNodeRandom ;
	    	 }
	    	 else
	    		 copyNode.random=null;
	    	 tmp = tmp.next;
	    	 q.next = copyNode;
	    	 q=q.next;
	     }
	     q.next=null;
	     return tmpResult.next;
	     
	 }
	 public RandomListNode isHasCopy ( Map<Integer,RandomListNode> hasCopyNodes,int label){
		 RandomListNode tmp = hasCopyNodes.get(label);
		 if(tmp!=null)
			 return tmp;
		 else{
			 tmp = new RandomListNode(label);
			 hasCopyNodes.put(label,tmp);
			 return tmp;
		 }
		
	 }
}
class RandomListNode {
	   int label;
	   RandomListNode next, random;
	   RandomListNode(int x) { this.label = x; }
	@Override
	public String toString() {
		String s = ""+this.label;
		
		if(this.random!=null)
			s=s+"random:"+this.random.label;
		if(this.next!=null)
			s=s+"next:"+this.next.label;
		return s;
	}
	   
 };
