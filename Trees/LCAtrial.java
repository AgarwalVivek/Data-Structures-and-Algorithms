

public class LCAtrial {
	Node root;
	Node root1;
	Node elt1;
	Node elt2;
	class Node{
		double data;
		Node left, right;
		Boolean isVisited;
		int children;
		Node(double d){
			data = d;
			left = right = null;
			isVisited = false;
		
		}
		public Node() {
			// TODO Auto-generated constructor stub
		}
		public boolean hasChild() {
			// TODO Auto-generated method stub
			
			return this.left != null || this.right != null;
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
	
	private void inOrderTraversal(Node root) {
		// TODO Auto-generated method stub
		
		if(root != null) {
			inOrderTraversal(root.left);
			
			System.out.println(root.data);
			inOrderTraversal(root.right);
		}
		
	}
	private Node findParent(Node child) {
		 Node parent = root;
		 Node prev = root;

		 while (parent != null) {
		
			 if(parent == child) {
	
				 return prev;
			
			 } else {
				 if (parent.data > child.data) {
					
					 prev = parent;
					 parent = parent.left;
				 } else {
			     System.out.println("her");
				 prev = parent;
				 parent = parent.right;
				 }
			 } 
		 }
		 
		 return parent != null ? prev: parent;
			 
		 		

		// TODO Auto-generated method stub
	
		
	}
public static void main(String[] args) {
		
		LCAtrial obj = new LCAtrial();
		obj.root = obj.insert(obj.root, 50);
		obj.root = obj.insert(obj.root, 30);
		obj.root = obj.insert(obj.root, 20);
		obj.root = obj.insert(obj.root, 40);
		
		obj.root = obj.insert(obj.root, 70);
//	
		obj.root = obj.insert(obj.root, 60);
		obj.root = obj.insert(obj.root, 80);

		 /*   tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
		 */
//		obj.root1 = obj.delete(obj.root, 20, 0);
//		obj.root1 = obj.delete(obj.root, 30, 0);
		//obj.root1 = obj.delete(obj.root, 50, 0);

		if (obj.root == null)
			System.out.println("not found");
		else {
			System.out.println("found");
			obj.elt1 = obj.findNode(obj.root, 30);
			obj.elt2 = obj.findNode(obj.root, 20);
			if (obj.elt1 != null)System.out.println(obj.elt1.data);
			if (obj.elt2 != null)System.out.println(obj.elt2.data);
			
			obj.root1 = obj.findParent(obj.root.left.left);
			//System.out.println(obj.root1.data);
			
		}
	}

private Node findNode(Node root, int item) {
	// TODO Auto-generated method stub
	if (root != null) {
		if (root.data == item)
			return root;
		else if (root.data > item) {
			return  findNode(root.left, item);
		} else {
			return findNode(root.right, item);
		}
	
	} 
		return root;
}
}
