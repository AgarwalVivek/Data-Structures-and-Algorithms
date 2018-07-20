

public class mergeSortLL {

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
		 mergeSortLL   linkedList = new  mergeSortLL();
		 linkedList.insert(10);
	
		linkedList.insert(2);
		for(int i = 99; i < 109; i++) {
			linkedList.insert(i);
		}
		linkedList.insert(9);
		linkedList.insert(5);
		linkedList.insert(6);
		linkedList.insert(7);
		linkedList.insert(100);
		linkedList.head.next.next.next = linkedList.head;
		System.out.println("herex");
		System.out.println(linkedList.hasLoop(linkedList.head));
	
		

		//linkedList.printLL(linkedList.head);
		System.out.println();
//		linkedList.head.random = linkedList.head.next;
//		linkedList.head.next.random = linkedList.head;
//		linkedList.head.next.next.random = linkedList.head.next.next;
//		linkedList.head.next.next.next.random = linkedList.head;
//		linkedList.head.next.next.next.next.random = linkedList.head;
//		
		NodeLL head = linkedList.mergeSort(linkedList.head);
		System.out.println();
		linkedList.printLL(head);
	
	
	}
	private NodeLL mergeSort(NodeLL head) {
		// TODO Auto-generated method stub
		if(head == null || head.next == null) {
			return head;
		}
		
		NodeLL middle = getMiddle(head);
		NodeLL nextOfMiddle = middle.next;
		middle.next = null;
		
		NodeLL left = mergeSort(head);
		NodeLL right = mergeSort(nextOfMiddle);
		 return merge(left, right);

		
	}
	private NodeLL merge(NodeLL left, NodeLL right) {
		// TODO Auto-generated method stub
		
		if(left == null) return right;
		if(right == null) return left;
		NodeLL result = null;
		if(left.item <= right.item) {
			result = left;
			result.next = merge(left.next, right);
		} else {
			result = right;
			result.next = merge(left, right.next);
		}
		return result;
	}
	private NodeLL getMiddle(NodeLL head) {
		// TODO Auto-generated method stub
		if(head == null|| head.next == null || head.next.next == null)
			return head;
		
		NodeLL slow = head, fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
		}
		System.out.println(slow.item);
		return slow;
	}
	
	private NodeLL hasLoop(NodeLL head) {
		
		
		NodeLL fast = head, slow = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			System.out.println("here");
			if(slow == fast)
				return slow;
			System.out.println("here");
		}
		return null;
		
	}

}
