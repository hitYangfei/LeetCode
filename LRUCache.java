import java.util.Hashtable;
import java.util.Map;


public class LRUCache {
	public DoubleLinkedNode linkedList;
	public Map<Integer,Node> keyValue;
	private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.linkedList = new DoubleLinkedNode();
        this.keyValue = new Hashtable<Integer,Node>();
       
    }
    public int get(int key) {
        Node tmp = keyValue.get(key);
        if(tmp!=null){
        	linkedList.moveElement(tmp);
        	return tmp.value;
        }
        else
        	return -1;
    }
    
    public void set(int key, int value) {
    	Node tmp = keyValue.get(key);
        if(tmp!=null){
        	linkedList.moveElement(tmp);
        	tmp.value = value;
        }
        else{
        	Node tmpNode = new Node(key,value);
        	if(linkedList.counts==this.capacity){
        		Node a = linkedList.removeElement();
        		keyValue.remove(a.key);
        		linkedList.addElement(tmpNode);
        		keyValue.put(key, tmpNode);
        	}
        	else{
        		linkedList.addElement(tmpNode);    
        		keyValue.put(key, tmpNode);
        	}
     
        }
    }
	@Override
	public String toString() {
		return "LRUCache [linkedList=" + linkedList + ", keyValue=" + keyValue
				+ ", capacity=" + capacity + "]";
	}
    
}

class DoubleLinkedNode{
	public Node head;
	public Node tail;
	public int counts;
	
	public DoubleLinkedNode() {
		this.head=null;
		this.tail=null;
		this.counts=0;
	}
	public void addElement(Node tmp){
	
		if(this.head==null){
			this.head = tmp;
			this.tail = tmp;
		}
		else{
			this.tail.next = tmp;
			tmp.prev = tail;
			tail = tail.next;
		}
		counts++;
	}
	public Node removeElement(){
		Node tmp = this.head;
		this.head = this.head.next;
		if(this.head==null)
			this.tail=null;
		counts--;
		return tmp;
	}
	public void moveElement(Node node){
		if(this.tail==node)
			return;
		if(this.head==node){
			tail.next = head;
			head.prev = tail;
			head = head.next;
			tail = tail.next;
			tail.next = null;
			head.prev = null;
		
		}
		else{
			node.next.prev = node.prev;
			node.prev.next = node.next;
			this.tail.next = node;
			node.prev = tail;
			tail = tail.next;
			tail.next=null;
		}
		
	}
	@Override
	public String toString() {
		return "DoubleLinkedNode [head=" + head.key  + ", tail=" + tail.key 
				+ ", counts=" + counts + "]";
	}
	
}
class Node{
	public int key;
	public int value;
	public Node next;
	public Node prev;
	public Node(int key,int value){
		this.key = key;
		this.value = value;
		this.next = null;
		this.prev = null;
	}
	@Override
	public String toString() {
		
		if(next==null&&prev==null)
			return "Node [data=" + key + "]";
		else if(next==null){
			return "Node [data=" + key + ", prev=" + prev.key  + "]";
		}
		else if(prev==null){
			return "Node [data=" + key  + ", next=" + next.key  + "]";
		}
		return  "Node [data=" + key + ", next=" + next.key  + ", prev=" + prev.key  + "]";
	}
	
}