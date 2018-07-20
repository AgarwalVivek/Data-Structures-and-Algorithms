

/**
 * Definition for singly-linked list.

 */


public class addNumbers {
	  public class ListNode {
	      int val;
	      ListNode next;
	      public ListNode(int x) { val = x; }
	  }
    public int getLen(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }
    public ListNode insertBefore(ListNode cur, int item, int count){
        ListNode temp = new ListNode(item);
        int i = 0;
      
        while(i < count){
            if(cur == null){
               
               cur = temp;
              
            
            } else{
                temp.next = cur;
                cur = temp;
            }
            temp = new ListNode(item);
            i++;
        }
        
        return cur ;
    }
    class PartialSum{
        ListNode sum;
        int carry;
        public PartialSum(){
            sum = null;
            carry = 0;
        }
    }
    
    public PartialSum addNumbers(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return new PartialSum();
        }
        PartialSum sum = addNumbers(l1.next, l2.next);
        int val = l1.val + l2.val+ sum.carry;
        int s = val % 10;
        int c = val / 10;
        ListNode result = insertBefore(sum.sum, s, 1);
        sum.sum = result;
        sum.carry = c;
        return sum;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLen(l1);
        int len2 = getLen(l2);
        if(len1 > len2){
            l2 = insertBefore(l2, 0, len1-len2);
        } else if(len2 > len1){
            l1 = insertBefore(l1, 0, len2 - len1);
        }
        
        PartialSum sum = addNumbers(l1, l2);
        
        return sum.sum;
        
    }
    public static void main(String args[]) {
    		addNumbers obj = new addNumbers();
    		ListNode ll = obj.new ListNode(9);
        
        ll.next = obj.new ListNode(5);
        //ll.next.next = obj.new ListNode(1);
        


  		ListNode ll1 = obj.new ListNode(1);
        
        ll1.next = obj.new ListNode(4);
        ll1.next.next = obj.new ListNode(6);
        
        ListNode result = obj.addTwoNumbers(ll, ll1);
        obj.printList(result);
        //System.out.println(result == null ? null : result.val);
    }
	private void printList(ListNode result) {
		// TODO Auto-generated method stub
		ListNode cur = result;
		while(cur != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
		
	}
}