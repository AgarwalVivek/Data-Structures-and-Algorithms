import java.util.Stack;

public class addLinkedList {
	myLinkedList list1;
	myLinkedList list2;
	Stack<Integer> l1 = new Stack<>();
	class myLinkedList{
		int val;
		myLinkedList next;
		myLinkedList(int data){
			val = data;
			next = null;	
		}
		public int getVal() {
			// TODO Auto-generated method stub
			return this.val;
		}
		
	}
	public int  addLinkedList(myLinkedList list1, myLinkedList list2) {
		// TODO Auto-generated constructor stub
		if(list1 == null)
			return 0;
		
		
		int carry = addLinkedList(list1.next, list2.next);
		int sum = list1.val + list2.val+ carry;
		if (sum > 9) {
			carry = sum/10;
			System.out.println(carry+"\t was carry");
			sum = sum %10;
		}
		l1.push(sum);
		return carry;
	}
	
	public myLinkedList formList(int item, myLinkedList node) {
		myLinkedList cur = node;
		
		if(cur == null) {
		
			cur = new myLinkedList(item);
		
		} else {
	
			myLinkedList prev = cur;
			while(prev.next != null) {
				prev = prev.next;
			}
			prev.next = new myLinkedList(item);
			
		}
		return cur;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addLinkedList obj = new addLinkedList();
		obj.list1 = obj.formList(4, obj.list1);
		obj.list1 = obj.formList(5, obj.list1);
		obj.list1 = obj.formList(6, obj.list1);
		obj.list2 = obj.formList(9, obj.list2);
		obj.list2 = obj.formList(8, obj.list2);
		obj.list2 = obj.formList(7, obj.list2);
		Integer carry;
		carry = obj.addLinkedList(obj.list1, obj.list2);
		if(carry == 1) obj.l1.push(carry);
		if(carry > 0) System.out.println("yesz");
		System.out.println("here");
		obj.printStack(obj.l1);
		
		

	}

	private void printStack(Stack<Integer> l12) {
		// TODO Auto-generated method stub
		
		while(l12.isEmpty() == false)
			System.out.println(l12.pop());
		
	}

	private void printList(myLinkedList list) {
		// TODO Auto-generated method stub
		myLinkedList n = list;
		
		while(n != null) {
			System.out.println(n.getVal());
			n = n.next;
		}
		
	}

}
