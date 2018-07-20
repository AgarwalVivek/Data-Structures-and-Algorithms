
public class DoublyLinkedList {
	int key;
	int value;
	DNode head;
	DNode tail;
	public void removeFirst() {
		// TODO Auto-generated method stub
		if(head != null) {
		  
		}
		
	}
	public void remove(DNode node) {
	
		if(node == null) return;
		
		if(node.prev == null && node.next == null) {
			head = null;
			tail = null;
			return;
		}
		//head to be deleted
		if(node.prev == null && node.next != null) {
			node.next.prev = null;
			head = node.next;
			return;
			
		}
		//middle to be deleted
		if(node.prev !=  null && node.next != null) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		//tail to be deleted
		if(node.next == null && node.prev != null) {
			node.prev.next = null;
			tail = node.prev;
			return;
		}
		
		
	}
	//add to head and its most recently used entry
	public void add(DNode node) {
		// TODO Auto-generated method stub
		if(head == null) {
			node.prev = null;
			node.next = null;
			head = node;
			tail = node;
			return;
		}
		
//		node.prev = null;
//		head.prev = node;
//		node.next = head;
//		node.prev = null;
//		head = node;
		node.next = head;
		head.prev = node;
		node.prev = null;
		head = node;
	}
		
		
		
	//tail is least recently used
	public DNode findCandidate() {
		// TODO Auto-generated method stub
		DNode temp = tail;
		remove(tail);
		return temp;
	}
	public void moveToFront(DNode node) {
		// TODO Auto-generated method stub
		remove(node);
		add(node);
		
		
	}
	
	
	

}
