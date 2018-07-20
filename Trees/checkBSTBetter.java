

public class checkBSTBetter {
	public static int count = 0;
	
	class Node{
		int data;
		Node parent;
		Node left, right;
		public Node(int d){
			data = d;
			left = right = null;
		}
		public Node(Node x, int d) {
			x.data = d;
			x.right = null;
			x.left  = null;
		}
	}

	private Node root;
	private Node current = null;
	private Node previous = null;
	public Node insert(Node root, int item) {
		if (root == null) {
			root = new Node(item);
	
		} else {
			if(root.data < item) {
				root.right = insert(root.right, item);
				root.right.parent = root;
			} else {
				root.left = insert(root.left, item);
				root.left.parent = root;
			}
		}
		return root;
	}
	
	private Boolean checkBST(Node root) {
		count++;
		if(root == null) 
			return true;
		
		Boolean checkLeft = checkBST(root.left);
		if (checkLeft != true) 
			return false;
	
		if (previous != null && previous.data > root.data) {
			return false;
		}
		previous = root;

		Boolean checkRight = checkBST(root.right);
		if (checkRight != true) 
			return false;
		
		return true;
		}
		
	
	private Node inOrderTraversal(Node root, int flag) {
		// TODO Auto-generated method stub
		if(root != null) {

		
				
			inOrderTraversal(root.left, 0);
			System.out.print(root.data+"has parent ");
			System.out.println(root.parent != null?root.parent.data : null);
			inOrderTraversal(root.right, 1);
			
		}
		return root;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		checkBSTBetter obj = new checkBSTBetter();

		obj.root = obj.insert(obj.root, 20);
		obj.root = obj.insert(obj.root, 10);
		obj.root = obj.insert(obj.root, 30);
		obj.root = obj.insert(obj.root, 35);
	
		obj.root = obj.insert(obj.root, 5);
		
		obj.root = obj.insert(obj.root, 15);
		obj.root = obj.insert(obj.root, 3);
		obj.root = obj.insert(obj.root, 7);
		obj.root = obj.insert(obj.root, 17);
		
		System.out.println(obj.checkBST(obj.root));
		System.out.println(count);
		

	}

}
