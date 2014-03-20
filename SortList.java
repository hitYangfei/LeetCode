
public class SortList {
	public static void main(String[] argvs){
		ListNode a = new ListNode(5);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(3);
		ListNode e = new ListNode(1);
		a.next=b;
		b.next=c;
		c.next=d;
		d.next=e;
		ListNode head = sortList(a);
		while(head!=null){
			System.out.println(head.val);
			head=head.next;
		}
	}
    public static ListNode sortList(ListNode head) {
    	if(head==null)
    		return null;
    	int size=0;
    	ListNode a = new ListNode(0);
    	a.next = head;
    	ListNode tmp = head;
    	for(int i=0;tmp!=null;i++){
    		tmp=tmp.next;
    		size++;
    	}
    	mergeSort(a,1,size);
        return a.next;
    }
    public static ListNode mergeSort(ListNode head,int begin,int end) {
    	if(begin==end)
    		return head;
    	
    	else{
    		int middle = (begin+end)/2;
    		ListNode left = mergeSort(head,begin,middle);
    		ListNode tmp = head;
    		for(int i=0;i<middle-begin+1;i++){
    			tmp = tmp.next;
    		}
    		ListNode right = mergeSort(tmp,middle+1,end);
    		return merge(left,middle-begin+1,right,end-middle);
    	}
    }
    public static ListNode merge(ListNode leftHead,int leftSize,ListNode rightHead,int rightSize) {
    	ListNode tmpLeft = leftHead;
    	ListNode tmpRight = rightHead;
    	int i=0,j=0;
    	while(i<leftSize&&j<rightSize){
    		if(tmpLeft.next.val>tmpRight.next.val){
	    		ListNode tmpL = tmpLeft.next;
	    		ListNode tmpR = tmpRight.next;
	    		ListNode tmpRNext = tmpRight.next.next;
	    		tmpR.next = tmpL;
	    		tmpLeft.next = tmpR;
	    		tmpRight.next = tmpRNext;
	    		j++;
    			tmpLeft = tmpLeft.next;
    		}
    		else{
	    		tmpLeft = tmpLeft.next;
	    		i++;
    		}
    	}
    	
    	return leftHead;
    
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
			return "ListNode [val=" + val + ", next=" + next.val + "]";
		}
	    
	 }