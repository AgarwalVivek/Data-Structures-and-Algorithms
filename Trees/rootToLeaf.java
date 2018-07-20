import java.util.Stack;

public class rootToLeaf {
	Stack<Node> s = new Stack<>();
	public rootToLeaf() {
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
	
	public Node root2Leaf(Node root) {
		
		if (root == null) return root;
		
		s.push(root);
		
		root.left = root2Leaf(root.left);
		 root.right = root2Leaf(root.right);
		if (root.left == null && root.right == null)
			printStack(s);
		s.pop();
		return root;
		
		
	}
	private void printStack(Stack<Node> s) {
		// TODO Auto-generated method stub
		for(Node m: s) {
			System.out.println(m.data);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rootToLeaf obj =new rootToLeaf();
		obj.root = obj.insert(obj.root, 50);
		obj.root = obj.insert(obj.root, 30);
		obj.root = obj.insert(obj.root, 20);
		obj.root = obj.insert(obj.root, 40);
		
		obj.root = obj.insert(obj.root, 70);
//	
		obj.root = obj.insert(obj.root, 60);
		obj.root = obj.insert(obj.root, 80);
		obj.inOrderTraversal(obj.root,0);
		obj.root2Leaf(obj.root);
	}

}
