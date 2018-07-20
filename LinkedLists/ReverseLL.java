import java.util.HashMap;



public class ReverseLL {
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
		ReverseLL  linkedList = new ReverseLL();
		 linkedList.insert(1);
	
		linkedList.insert(2);
		
		linkedList.insert(4);
		linkedList.insert(5);
		linkedList.insert(6);
		//linkedList.insert(7);
		//linkedList.insert(8);
		//linkedList.insert(9);
		//linkedList.printLL(linkedList.head);
		System.out.println();
		linkedList.head.random = linkedList.head.next;
		linkedList.head.next.random = linkedList.head;
		linkedList.head.next.next.random = linkedList.head.next.next;
		linkedList.head.next.next.next.random = linkedList.head;
		linkedList.head.next.next.next.next.random = linkedList.head;
	
		//linkedList.reverse(linkedList.head);
		NodeLL node = linkedList.reverseInGroup(linkedList.head, 3);
		
		linkedList.printLL(node);
	}
	private NodeLL reverseInGroup(NodeLL head, int j) {
		// TODO Auto-generated method stub
		
		NodeLL cur = head, prev = null,next = null;
		
		int count = 0;
		while(count < j && cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
			count++;
		}
		
		if(cur != null) {
			head.next  = reverseInGroup(cur, j);
		}
		return prev;
		
	}
	private void reverse(NodeLL head) {
		// TODO Auto-generated method stub
		
		if(head == null || head.next == null) 
			return;
		
		NodeLL cur = head, next;
		NodeLL prev = next = null;
		
		while(cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		printLL(prev);
		
		
	}

}
