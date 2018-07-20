import java.util.Stack;


public class ZigZag {

	public ZigZag() {
		// TODO Auto-generated constructor stub
	}
	class Node{
		int data;
		Node parent;
		Node left, right;
		Node(int d){
			data = d;
			left = right = null;
		}
	}

	private Node root;
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
	
	public void spiralOrder(Node root) {
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		if (root == null) return;
		
		s1.push(root);
		
		while (!s1.isEmpty() || !s2.isEmpty()) {
			
			while(!s1.isEmpty()) {
				Node item = s1.pop();
				System.out.println(item.data);
				if (item.left != null) s2.push(item.left);
				if (item.right != null) s2.push(item.right);
			}
			
			while(!s2.isEmpty()) {
				Node item = s2.pop();
				System.out.println(item.data);
				if (item.right != null) s1.push(item.right);
				if (item.left != null) s1.push(item.left);
			}
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ZigZag obj = new  ZigZag();
		obj.root = obj.insert(obj.root, 50);
		obj.root = obj.insert(obj.root, 30);
		obj.root = obj.insert(obj.root, 20);
		obj.root = obj.insert(obj.root, 40);
		
		obj.root = obj.insert(obj.root, 70);
//	
		obj.root = obj.insert(obj.root, 60);
		obj.root = obj.insert(obj.root, 80);
		obj.inOrderTraversal(obj.root,0);
		obj.spiralOrder(obj.root);
	}

}
