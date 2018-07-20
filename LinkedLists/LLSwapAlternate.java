public class LLSwapAlternate {

	
	class NodeLL{
		int item;
		NodeLL next;
		
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
			System.out.print(n.item+"\t");
			n = n.next;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LLSwapAlternate  linkedList = new LLSwapAlternate ();
		 linkedList.insert(1);
	
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(5);
		linkedList.insert(6);
		linkedList.insert(7);
		linkedList.insert(8);
		//linkedList.insert(9);
		linkedList.printLL(linkedList.head);
		NodeLL temp = linkedList.swap();
		System.out.println();
		linkedList.printLL(temp);
		
		
		
		

	}
	private NodeLL swap() {
		
		if(head == null || head.next == null) return head;
		
		NodeLL toReturn = head.next;
		
		NodeLL p = head, q = null, temp = null;
		
		while(true) {
			q = p.next;
			temp = q.next;
			
			q.next = p;
			if(temp == null ) {
				p.next = null;
				break;
			} else if( temp.next == null) {
				p.next = temp;
				break;
			}
			p.next = temp.next;
			p = temp;
		}
		
		return toReturn;
	}
}
