

public class SizeOfTreeRecursion {
	Node root;
	class Node{
		int data;
		Node left, right;
		Boolean isVisited;
		int children;
		Node(int d){
		data = d;
		left = right = null;
		isVisited = false;
		
		}
		public Node() {
		isVisited = false;
		left = right = null;
			// TODO Auto-generated constructor stub
		}
	}
	public Node insert(Node root, int item) {
		if (root == null) {
			root = new Node(item);
		} else {
			if(root.data < item) {
				root.right = insert(root.right, item);
			} else {
				root.left = insert(root.left, item);
			}
		}
		return root;
	}

	public int SizeOfTree(Node root) {
		if (root != null) {
			return(SizeOfTree(root.left) + 1 + SizeOfTree(root.right));
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SizeOfTreeRecursion obj = new SizeOfTreeRecursion();
		obj.root = obj.insert(obj.root, 2);
		obj.root = obj.insert(obj.root, 1);
		obj.root = obj.insert(obj.root, 3);
		obj.root = obj.insert(obj.root, -1);
		obj.root = obj.insert(obj.root, 4);
		obj.root = obj.insert(obj.root, 5);
		System.out.println(obj.SizeOfTree(obj.root));
		

	}

}
