
public class DoubleLinkedList {
	NodeDDL head;
	NodeDDL tail;
	class NodeDDL{
		int item;
		NodeDDL left;
		NodeDDL right;
		public NodeDDL(int x) {
			this.item = x;
			left = right = null;
		}
	}
	
	public void insertHead(int item) {
		NodeDDL temp = new NodeDDL(item);
		if(head == null) {
			head = temp;
			tail = temp;
			return;
		} else {
			temp.right = head;
			head.left = temp;
			head = temp;
			
		}
	}
	public void insertTail(int item) {
		NodeDDL temp = new NodeDDL(item);
		if( tail == null) {
			head = temp;
			tail = temp;
			return;
		}
		//head and tail nodes only
		if(head == tail) {
			head.right = temp;
			temp.left = head;
			tail = temp;
			return;
		}
		
		tail.right = temp;
		temp.left = tail;
		tail = temp;
		
		
	}
	
	public void insertPoint(int item, NodeDDL n) {
		//empty
		NodeDDL temp = new NodeDDL(item);
		if(n == null) {
			insertHead(item);
			return;
		}
		if(n.left == null && n.right != null) {
			insertHead(item);
			return;
		}
		if(n.left != null && n.right == null) {
			insertTail(item);
			
		} else if(n.left != null && n.right != null){
			System.out.println("here");
			temp.left = n;
			temp.right = n.right;
			n.right.left = temp;
			n.right = temp;	
			
		}
		//only one node
		//head
		//tail
		//middle
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.insertHead(1);;
		obj.insertHead(0);
		obj.insertTail(2);
		obj.insertPoint(3, obj.head.right);
//		obj.removeHead();
//		obj.removeTail();
		obj.moveToFront(obj.head.right.right);
		
		//obj.remove(obj.head.right.right);
		NodeDDL x = obj.head;
		while(x != null) {
			System.out.println(x.item);
			x = x.right;
		}

	}
	private void remove(NodeDDL n) {
		// TODO Auto-generated method stub
		if(n == null) return;
		if(n.left == null && n.right == null) {
			n = null;
			head = tail = null;
			return;
		}
		if(n.left == null && n.right != null) {
			removeHead();
			return;
		}
		if(n.right == null && n.left != null) {
			removeTail();
			return;
		} else if(n.right != null && n.left != null) {
			
			n.left.right = n.right;
			n.right.left = n.left;
			
		}
		
	}
	private void moveToFront(NodeDDL n) {
		remove(n);
		insertHead(n.item);
	}
	private void removeTail() {
		
		// TODO Auto-generated method stub
		if(head == null) return;
		if(head == tail) {
			head = tail = null;
			return;
		}
		
		tail.left.right = null;
		tail = tail.left;
		tail.right = null;
		
	}
	private void removeHead() {
		// TODO Auto-generated method stub
		if(head == null) return;
		if(head == tail) {
			head = tail = null;
			return;
		}
		
		head.right.left = null;
		head = head.right;
		head.left = null;
		
	}

}
