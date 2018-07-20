import java.util.LinkedList;
import java.util.Queue;

public class sortedList2Tree {
	Node root;
	ListNode head;
	class Node{
		int data;
		Node left;
		Node right;
		public Node(int  data) {
			this.data = data;
			left = right = null;
		}
	}
		class ListNode{
			int val;
			ListNode next;
			
			public ListNode(int val) {
				this.val = val;
				this.next = null;
			}
		
		}
	public sortedList2Tree() {
		// TODO Auto-generated constructor stub
	}

	public ListNode push(ListNode head, int item) {
		if (head == null) {
			head = new ListNode(item);
		} else {
			 ListNode cur = head;
			 while(cur.next != null) {
				 cur = cur.next;
			 }
			 cur.next = new ListNode(item);
		}
			return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sortedList2Tree obj = new sortedList2Tree();
		obj.head = obj.push(obj.head, 1);
		obj.head = obj.push(obj.head, 2);
		obj.head = obj.push(obj.head, 3);
		obj.head = obj.push(obj.head, 4);
		obj.printList(obj.head);
		
		//now form tree
		
		//using Queue for tracking parent works like BFS
		
		Queue<Node> q = new LinkedList<>();
		obj.root = obj.convert2Tree(q, obj.head, obj.root);
		obj.inOrderTraversal(obj.root);
		System.out.println("here");
	}

	private  void inOrderTraversal(Node root) {
		// TODO Auto-generated method stu
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.println(root.data);
			inOrderTraversal(root.right);
		}
		
	}

	private Node convert2Tree(Queue<Node> q, ListNode head, Node root) {
		// TODO Auto-generated method stub
		
		if (head == null) return null;
		
		//add this node to queue which will help in keeping tradck of parent
		Node newRoot = new Node(head.val);
		q.add(newRoot);;
		
		
		while(head != null) {
			//get the parent
			
			Node parent = q.poll();
			
			
			//move head to next eleemtn put it into queue
			//maintain left and right child as needed
			Node leftChild = null, rightChild = null;
			head = head.next;
			
			if (head != null) {
				Node x = new Node(head.val);
				q.add(x);
				leftChild = x;
			}
			
			head = head.next;
			if (head != null) {
				Node x = new Node(head.val);
				q.add(x);
				rightChild = x;
			}
			parent.left = leftChild;
			parent.right = rightChild;
			
			
			
		}
		
		
		return newRoot;
	}

	private void printList(ListNode head) {
		// TODO Auto-generated method stub
		
		ListNode cur = head;
		while(cur != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
	}

}
