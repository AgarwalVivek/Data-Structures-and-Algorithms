
public class matchTrees {
	Node root;
	public static int count = 0;

	
	class Node{
		int data;
		Node left;
		Node right;
		
		Node(int d){
			data = d;
			left = right = null;
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
	
	private Boolean checkSubtree(Node root, Node subRoot) {
		// TODO Auto-generated method stub
		
		if (root != null) {
			//inOrder traversal
			//exit condition
			if (checkSubtree(root.left, subRoot)) return true;
			if (subRoot != null) {
				System.out.println(root.data+"\t\t"+subRoot.data);
				if (subRoot.data == root.data) {
					if (matchTree(root, subRoot) == true)
						return true;
				}
			}
			//exit condition
			if (checkSubtree(root.right, subRoot)) return true;
		}
		
		return false;
	
	
	}	
	private Boolean matchTree(Node root, Node subRoot) {
		// TODO Auto-generated method stub
//		debug(root, subRoot);
//		if (subRoot == null) {
//			return true;
//		}
//		
//		if (root != null) {
//			
//			if (subRoot.data == root.data) {
//				return matchTree(root.left, subRoot.left) && matchTree(root.right, subRoot.right);
//			} else
//				return false;
//		}
//		return false;
		debug(root, subRoot);
		if (subRoot == null)
			return true;
		if (root != null) {
			
			if (root.data == subRoot.data) {
				if (matchTree(root.left, subRoot.left)==true && matchTree(root.right, subRoot.right) == true) return true;
			}
			
		}
		return false;
  }

	



	private void debug(Node root2, Node subRoot) {
		// TODO Auto-generated method stub
		
		if (root2 != null) {
			System.out.print(root2.data+"\t");
		} else 
			System.out.print(root2+"\t");
		
		if (subRoot != null) {
			System.out.println(subRoot.data);
		} else 
			System.out.println(subRoot);
		
			
}
		
	private  void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.println(root.data);
			inOrderTraversal(root.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		matchTrees obj = new  matchTrees();
		obj.root = obj.insert(obj.root, 20);
		obj.root = obj.insert(obj.root, 10);
		obj.root = obj.insert(obj.root, 30);
		obj.root = obj.insert(obj.root, 35);
		obj.root = obj.insert(obj.root, 5);
		obj.root = obj.insert(obj.root, 3);
		obj.root = obj.insert(obj.root, 7);
		obj.inOrderTraversal(obj.root);

		//Building subtree 
		 matchTrees obj1 = new  matchTrees();
		 
		obj1.root = obj1.insert(obj1.root, 5);
		
		obj1.root = obj1.insert(obj1.root, 3);
		
		obj1.root = obj1.insert(obj1.root, 7);
		obj1.root = obj1.insert(obj1.root, 8);
		
		
		
		System.out.println("Now subtree");
		System.out.println(obj.root.data+"\t"+obj1.root.data);
		System.out.println(obj.checkSubtree(obj.root, obj1.root));

	}



}
