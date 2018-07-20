

public class inOrderSuccessor {
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
	private Node inOrderTraversal1(Node root, int flag) {
		// TODO Auto-generated method stub
		if(root != null) {

		
				
			inOrderTraversal1(root.left, 0);
			System.out.print(root.data+"has parent ");
			System.out.println(root.parent != null?root.parent.data : null);
			inOrderTraversal1(root.right, 1);
			
		}
		return root;
		
	}
	
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
	
	private Node getNode(Node root, int item) {
		// TODO Auto-generated method stub
		if (root != null) {
			if (root.data == item) {
				return root;
			} else {
				if (root.data > item) {
					return getNode(root.left, item);
				} else {
					return getNode(root.right, item);
				}
			}
		}
		return null;
	}
	private static Node getSuccessor(Node root, Node target) {
		count++;
		//right most child
		if(target == null)
			return null;
		if (target.right != null) {
			Node elt = getLeftMost(target.right);
			return elt;
		} else {
			//the node is on right side of its parent
			Node parent = target.parent;
			Node child = target;
			
			while (parent != null && parent.left != child) {
				child = parent;
				parent = parent.parent;
			}
			return parent;
		}
	}

	private static Node getLeftMost(Node root) {
		count++;
		// TODO Auto-generated method stub
		Node prev = root;
		
		while(root != null) {
			prev = root;
			root = root.left;
		}
		
		return prev;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		inOrderSuccessor obj = new inOrderSuccessor();

		obj.root = obj.insert(obj.root, 20);
		obj.root = obj.insert(obj.root, 10);
		obj.root = obj.insert(obj.root, 30);
		obj.root = obj.insert(obj.root, 35);
	
		obj.root = obj.insert(obj.root, 5);
		
		obj.root = obj.insert(obj.root, 15);
		obj.root = obj.insert(obj.root, 3);
		obj.root = obj.insert(obj.root, 7);
		obj.root = obj.insert(obj.root, 17);
		
		//System.out.println(obj.checkBST(null, obj.root, null));


		Node x = obj.getNode(obj.root, 7);
	
		Node succ = getSuccessor(obj.root, x);
		if(succ != null) {
			System.out.println(succ.data);
		}
		System.out.println(count);

		
	
	}





}
