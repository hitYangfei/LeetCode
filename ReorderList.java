package yf.leetcode.solution8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReorderList {
	public static void main(String[] argvs){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next=node2;
		node2.next=node3;
		node3.next =node4;
		node4.next =node5;
		node5.next=null;
		reorderList(node1);
		ListNode p = node1;
		while(p!=null){
			System.out.print(p.val);
			p=p.next;
		}
	}
	public static void reorderList(ListNode head) {
		if(head==null)
			return ;
		int size=0;
		for(ListNode p = head;p!=null;p=p.next)
			size++;
		if(size==1&&size==2)
			return;
		Stack<ListNode> stackNode = new Stack<ListNode>();
		Queue<ListNode> queueNode = new LinkedList<ListNode>();
		ListNode p = head;
		int loop = 0;
		if(size%2==0)
			loop = size/2;
		else
			loop = size/2+1;
		for(int i=0;i<loop;i++){
			queueNode.add(p);
			p=p.next;
		}
		for(int i=loop;i<size;i++){
			stackNode.push(p);
			p=p.next;
		}
		ListNode tmp = new ListNode(0);
		tmp.next = head;
		p = tmp;
		int i=0;
		while(!stackNode.isEmpty()&&!queueNode.isEmpty()){
			if(i%2==0)
				p.next = queueNode.poll();
			else
				p.next = stackNode.pop();
			p=p.next;
			i++;
		}
		if(!stackNode.isEmpty())
			p.next = stackNode.pop();
		if(!queueNode.isEmpty())
			p.next = queueNode.poll();
		
		p = p.next;
		p.next= null;
		
		
		
	}
}
class ListNode {
	 int val;
	  ListNode next;
	 ListNode(int x) {
	  val = x;
	    next = null;
	 }
	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}
	 
}
