
public class ShruthiAMazon {

	//public ArrayList<Integer> calculateMin(int k, int windowSize)
	
	class ALNode{
		int value;
		ALNode next;
		ALNode arbitrary;
		public ALNode(int value) {
			this.value = value;
			next = null;
			arbitrary = null;
		}
	}
	public ALNode deepCopy(ALNode head) {
		
		if(head == null) return null;
		
		ALNode cur = head;
		ALNode newHead = new ALNode(head.value);
		while(cur != null) {
			ALNode temp = cur.next;
			cur.next = new ALNode(cur.value);
			cur.next.next = temp;
			cur = cur.next.next;
			
		}
		
		ALNode newHead1 = cur.next;
		//copy the random pointer
		while(cur != null) {
			cur.next.arbitrary = cur.arbitrary.next;
			cur = cur.next.next;
		}
		
		cur = newHead1;
		while(cur.next!= null) {
			cur = cur.next.next;
		}
		
		return newHead1;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
	}

}
