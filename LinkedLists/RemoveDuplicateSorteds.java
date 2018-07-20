import java.util.HashMap;

public class RemoveDuplicateSorteds {

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
	public NodeLL RandomPointerWithoutSpace(NodeLL head) {
		if(head == null && head.next == null) return head;
		
		NodeLL cur = head;
		NodeLL copy=null;
		NodeLL curCopy = copy;
	/*
	 * 1 2 3 
	 *1->((1))->2->3
	 * 1->1->2 (2) 3
	 * 1->1->2->2->3
	 * 1->1->2->2->3-> (3)->
	 * 3  3  1  1  1    
	 * 1->2->3
	*/
		
		while(cur != null) {
			curCopy = new NodeLL(cur.item);
			NodeLL temp = cur.next;
			cur.next =  curCopy;
			curCopy.next = temp;
			cur = temp;
		}
		
		cur = head;
		copy = cur.next;
	
	
		while(cur != null) {
			cur.next.random = cur.random.next;
			cur = cur.next.next;
		}

		cur = copy;
		while(cur.next!= null) {
			cur.next = cur.next.next;
			cur = cur.next;
		}
		return  copy;
	}
	public NodeLL RandomPointerWithSpace(NodeLL head) {
		if(head == null && head.next == null) return head;
		HashMap<NodeLL, NodeLL> hm = new HashMap<>();
		
		NodeLL cur = head;
		NodeLL copy = new NodeLL(head.item);
		
		hm.put(cur,  copy);
		NodeLL temp = copy;
		
		while(cur.next != null) {
			temp.next = new NodeLL(cur.next.item);
			hm.put(cur.next, temp.next);
			temp = temp.next;
			cur = cur.next;
			
		}
		
		cur = head;
		temp = copy;
		
		while(cur != null) {
		    temp.random = hm.get(cur.random);
			cur = cur.next;
			temp = temp.next;
		}
		
		return copy;
		
		
	}
	public void RemoveDuplicate(NodeLL head) {
			if(head == null && head.next == null) return;
			
			NodeLL p = head;
		
			while(p != null && p.next != null) {
				if(p.item == p.next.item) {
					NodeLL q = p.next.next;
					if(q == null) {
						p.next = null;
						break;
					}
					p.next = q;
				}
				
				if(p.item != p.next.item)
					p = p.next;
			
			}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicateSorteds  linkedList = new RemoveDuplicateSorteds();
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
		linkedList.RemoveDuplicate(linkedList.head);
		
		linkedList.printLL(linkedList.head);
		System.out.println();
		//NodeLL iter = linkedList.RandomPointerWithSpace(linkedList.head);
	
		//linkedList.printLL(iter.next.random);
		System.out.println();
		NodeLL copy = linkedList.RandomPointerWithoutSpace(linkedList.head);
		linkedList.printLL(copy);		
		
		

	}
}
