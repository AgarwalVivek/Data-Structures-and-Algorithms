package Bloomberg;
class ListNode{
	int item;
	ListNode next;
	public ListNode(int item) {
		this.item = item;
		next = null;
	}
}
public class AddLinkedList {
	class PartialSum{
		ListNode sum;
		int carry;
		PartialSum(){
			sum = null;
			carry = 0;
			
		}
	}
		ListNode addTwoNum(ListNode l1, ListNode l2) {
			int len1 = getLen1(l1);
			int len2 = getLen1(l2);
			if(len1 >len2)
				padList(l1, 0, len1-len2);
			else if(len2 > len1)
				padList(l2, 0, len2- len1);
			
			PartialSum result = getSum(l1, l2);
			if(result.carry == 0)
				return result.sum;
			else
				result.sum = insertBefore(result.sum, result.carry);
			return result.sum;
			
		}
		private int getLen1(ListNode l2) {
			// TODO Auto-generated method stub
			ListNode head = l2;
			int count = 0;
			while(head != null) {
				head = head.next;
				count++;
			}
			return count;
		}
		private void padList(ListNode l2, int elt, int count) {
			// TODO Auto-generated method stub
			int i = 0;
			while(i < count) {
				ListNode temp = new ListNode(elt);
				if(l2 == null) {
					l2 = temp;
				} else {
					temp.next = l2;
					l2 = temp;
				}
				i++;
				
			}
			
		}
		private PartialSum getSum(ListNode l1, ListNode l2) {
			// TODO Auto-generated method stub
			if(l1 == null || l2 == null)
				return new PartialSum();
			PartialSum sum = getSum(l1.next, l2.next);
			int total =  l1.item + l2.item+ sum.carry;
			int s = total%10;
			int carry = total/10;
			
			ListNode result = insertBefore(sum.sum, s);
			sum.sum = result;
			sum.carry = carry;
			return sum;
			
		}
		private ListNode insertBefore(ListNode sum, int s) {
			// TODO Auto-generated method stub
			if(sum == null) {
				sum = new ListNode(s);
				return sum;
			}
			ListNode temp = new ListNode(s);
			temp.next = sum;
			sum = temp;
			return sum;
		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(9);
		ListNode l2 = new ListNode(2);
		AddLinkedList obj = new AddLinkedList();
		
		l1.next = new ListNode(9);
		l2.next =new ListNode(3);
	    ListNode result = obj.addTwoNum(l1, l2);
	    
		printList(result);

	}
	private static void printList(ListNode result) {
		// TODO Auto-generated method stub
		while(result != null) {
			System.out.println(result.item);
			result = result.next;
		}
		
	}
	

}
