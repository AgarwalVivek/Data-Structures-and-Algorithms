
public class SingleLL {

	
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
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLL linkedList = new SingleLL();
		 linkedList.insert(1);
	
		linkedList.insert(2);
		linkedList.insert(3);
		System.out.println(linkedList.head.next.item);
		System.out.println(linkedList.delete(linkedList.head.next.next));
		while(linkedList.head != null) {
			System.out.println(linkedList.head.item);
			linkedList.head = linkedList.head.next;
		}
		

	}

}
