

public class MiddlePallinDrome {

	class NodeLL{
		int item;
		NodeLL next;
		NodeLL random;
		
		NodeLL(int item){
			this.item= item;
			next =  null;
		}
		
	}
	static int i = 0;
	NodeLL head;
	
	public void insert(int item) {
		
		if(head == null) {
			NodeLL node = new NodeLL(item);
			System.out.println(node.item);
			head = node;
			System.out.println(head.item);
			System.out.println("'gere'");
			return;
		} else {
			NodeLL cur = head;
			NodeLL prev = cur;
			while(cur != null) {
				prev = cur;
				cur = cur.next;
			}
			prev.next = new NodeLL(item);
			return;
			
		}
	}
	public boolean delete(NodeLL n) {
		
		//if emtpy
		if(n == null) return false;
		
		//if only one node
		if(n== head) {
			head = null;
			return true;
		} else {
			//any middle node
			NodeLL cur = head,prev;
		
			while(cur.next != n) {
				prev =cur;
				cur = cur.next;
			}
			if(n.next == null) {
				cur.next =null;
			} else {
				cur.next  = n.next;
				n = null;
			}
			return true;
		}
	}
	public void printLL(NodeLL head) {
		NodeLL n = head;
		while(n!= null) {
			NodeLL temp = n.random;
			
			System.out.print(n.item+"\t");
			if(temp != null) System.out.println("random is\t"+ temp.item);
			n = n.next;
		}
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiddlePallinDrome linkedList = new  MiddlePallinDrome();
		 linkedList.insert(1);
	
		linkedList.insert(2);
		
		//linkedList.insert(3);
		//linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(1);
		//linkedList.insert(7);
		//linkedList.insert(8);
		//linkedList.insert(9);
		//linkedList.printLL(linkedList.head);
		System.out.println();
		linkedList.head.random = linkedList.head.next;
		linkedList.head.next.random = linkedList.head;
		linkedList.head.next.next.random = linkedList.head.next.next;
		linkedList.head.next.next.next.random = linkedList.head;
//		linkedList.head.next.next.next.next.random = linkedList.head;
		linkedList.printLL(linkedList.head);
		boolean cur = linkedList.isPallindrome(linkedList.head);
		System.out.println(cur);
	}
	private  boolean isPallindrome(NodeLL head) {
		// TODO Auto-generated method stub
		if(head == null || head.next == null) return true;
		
		//lets find the middle node
		NodeLL fast = head;
		NodeLL slow = head;
		NodeLL prev = null;
		NodeLL newStart = null;
		
		while(fast != null && fast.next != null) {
			 prev = slow;
			 slow = slow.next;
			 fast = fast.next.next;
		}
	
		if(fast == null) {
			//even case
			newStart = slow;
	
			
		} else if(fast.next == null) {
			newStart = slow.next;
		}
		prev.next = null;
		
		NodeLL rotatedRight = getReversedRight(newStart);
		
		return isSame(head, rotatedRight);
		

	}
	private static boolean isSame(NodeLL head1, NodeLL head2) {
		// TODO Auto-generated method stub
		if(head1 == null && head2 == null) 
			return true;
		if((head1 == null && head2!= null) || head1 != null && head2 == null)
			return false;
		return head1.item == head2.item && isSame(head1.next, head2.next);
	}
	private static NodeLL getReversedRight(NodeLL head) {
		// TODO Auto-generated method stub
		if(head == null || head.next == null)
			return head;
		NodeLL cur = head, prev = null, next = null;
		
		while(cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}


}
