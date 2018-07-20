
public class RecursiveDeletion {
	Node root1;
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
	private Node findParent(Node root, int item) {
		// TODO Auto-generated method stub
		
		if (root == null) return null;
		
		if (root.data > item) {
			//keeping track ofthe parent
			root.left = findParent(root.left, item);
		} else if (root.data < item) {
			root.right = findParent(root.right, item);
		} else {
			if (root.left == null)
				return root.right;
			else if (root.right == null) {
				return root.left;
				
			} else {
				
				//both the children are present
				//traverse till end of rights'  left most child
				
				Node lBranch = root.left;
				Node right = root.right;
				Node rBranch = root.right;
				
				while(rBranch.left != null) {
					rBranch = rBranch.left;
					
				}
				rBranch.left = root.left;
				root.left = null;
			
				
				return root.right;
				
			}
		}
		System.out.println("here");
			return root;
	}
		
		
		
	
	public  static void main(String args[]) {
		RecursiveDeletion obj = new RecursiveDeletion();
		/*
		 *  tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
		 */
		obj.root1 = obj.insert(obj.root1, 50);
		
		obj.root1 = obj.insert(obj.root1, 30);
		
		obj.root1 = obj.insert(obj.root1, 20);
		obj.root1 = obj.insert(obj.root1, 40);
		obj.root1 = obj.insert(obj.root1, 70);
		obj.root1 = obj.insert(obj.root1, 60);
		obj.root1 = obj.insert(obj.root1, 80);
	
	
		obj.inOrderTraversal(obj.root1);
		System.out.println("DS");
		Node parent =obj.findParent(obj.root1, 50);
		obj.root1 = parent;
		obj.inOrderTraversal(obj.root1);
		//System.out.println(parent.data);
	
	}


	
}
