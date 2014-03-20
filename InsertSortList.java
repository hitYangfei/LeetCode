
public class InsertSortList {
	public static void main(String[] argvs){
		ListNode a = new ListNode(3);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(4);
		
		a.next=b;
		b.next=c;
		c.next=null;
	
		ListNode head = sortList(a);
		while(head!=null){
			System.out.println(head.val);
			head=head.next;
		}
	}
    public static ListNode sortList(ListNode head) {
    	if(head==null)
    		return null;
    	if(head.next==null)
    		return head;
    	
    	ListNode returnNodeHead = new ListNode(0);
    	returnNodeHead.next=head;
    	head = head.next;
    	returnNodeHead.next.next=null;
    	boolean isLastOne = true;
    	while(head!=null){
    		ListNode p = returnNodeHead;
    		isLastOne = true;
    		while(p.next!=null){
    			if(p.next.val>head.val){
    				ListNode tmp = p.next;
    				p.next=head;
    				head=head.next;
    				p.next.next = tmp;
    				isLastOne = false;
    				break;
    			}
    			p=p.next;
    		}
    		if(isLastOne){
    			p.next = head;
    			head = head.next;
    			p.next.next=null;
    		
    		}
    	}

    	return returnNodeHead.next;
    }
}

